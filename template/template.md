#模板模式
##应用场景
我们平时办理入职流程填写入职登记表，打印简历，复印学历等等，都在应用模板模式

模板模式通常又叫模板方法模式是定义一个算法的骨架，并允许子类为一个或者多个步骤提供实现。模板方法使得子类可以在不改变算法结构的
情况下，重新定义算法的某些步骤，属于行为性模式。
模板方法使用于以下应用场景：
1、一次性实现一个算法的不变的部分，并将可变的行为留给子类来实现。
2、各子类中公共的行为被提取出来并集中到一个公共的父类中，从而避免代码重复

###利用模板模式重构JDBC操作的业务场景
创建一个模板类JdbcTemplate，封装所有的JDBC操作。以查询为例，每次查询的表不同，返回的数据结构也就不一样。针对不同的数据，
都要封装成不同的实体对象。而每个实体封装的逻辑都是不一样的，但封装前和封装后的处理流程是不变的，因此我们可以使用模板方法模式
来设计这样的业务场景。
1、创建约束ORM逻辑的接口 RowMapper
2、在创建封装了所有流程的抽象类JdbcTemplate
3、创建实体类Member
4、创建数据库操作类 MemberDao


##模板模式在源码中的体现
先看JDK中的AbstractList,
    
    public abstract class AbstractList<E> extends AbstractCollention<E> implements List<E>{
        ...
        abstract public E get(int index);
        ...
    }
    
 get方法就是一个抽象方法，它的逻辑就是交给子类来实现，我们知道的ArrayList 就是AbstractList的子类。
 
 同理，AbstractList还有AbstractSet和AbstractSet和AbstractMap
 以及经常使用的HttpServlet的三个方法service()、doGet()、doSet() 都是模板方法的实现
 
 在MyBatis框架也有一些经典的应用，例如BaseExecutor类，它是一个基础的SQL执行类，实现了大部分SQL执行逻辑，然后把几个方法交给子类
 定制化完成。
 源码如下：
    
    public abstract class BaseExecutor implements Executor{
        ...
        protected abstract int doUpdate(MappedStatement var1,Object var2)throws SQLException;
        
        protected abstract List<BatchResult> doFlushStatements(boolean var1)throws SQLException;
        
        protected abstract <E> List<E> doQuery(MappedStatement var1,Object var2,RowBounds var3,ResultHandler var4,
        BoundSql var5)throws SQLException;
        
        protected abstract <E> Cursor<E> doQueryCursor(MappedStatement var1,Object var2,RowBounds var3,
        BoundSql var4)throws SQLexception;
        
        ...
    }

例如：doUpdate，doFlushStatements，doQuery，doQueryCursor这几个方法就是交由子类实现，那么BaseExecutor有哪些子类？如下：
![images](http://git.gupaoedu.com/caowen/pattern/blob/master/template/image/SimpleExecutor.jpg)
    
 我们对比一个SimpleExecutor的doUpdate方法和BatchExecutor的doUpdate方法
 SimpleExecutor
    
    public int doUpdate(MappedStatement ms,Object parameter)throws SQLException{
        Statement stmt = null;
        
        int var6;
        try{
            Configuration configuration = ms.getConfiguration();
            StatementHandler handler = configuration.newStatementHandler(this,ms,parameter,
            RowBounds.DEFAULT,(ResultHandler)nulll,(BoundSql)null);
            stmt = this.prepareStatement(handler,ms.getStatementLog());
            var6 = handler.update(stmt);
            
        }finally{
            this.closeStatement(stmt);
        }
        
        return var6;
    }

BatchExecutor:
    
    public int doUpdate(MappedStatement ms,Object parameterOject)throws SQLExceptin{
        Configureation cofiguration = ms.getConfiguration();
        StatementHandler handler = configuration.newStatementHandler(this,ms,parameterObject,
        RowBounds.DEFAULT,(ResultHandler)null,(BoundSql)null);
        BoundSql sql = boundSql.getSql();
        Statement stmt;
        if(sql.equals(this.currentSql) && ms.equals(this.currentStatement)){
            int last = this.statementList.size() -1 ;
            stmt = (Statement)this.statementList.get(last);
            this.applyTransactionTimeout(stmt);
            handler.parameterize(stmt);
            BatchResult batchResult = (BatchResult)this.batchResultList.get(last);
            batchResult.addParameterobject(parameterObject);
        }else{
            Connection connection = this.getConnection(ms.getStatementLog());
            stmt = handler.prepare(connection,this.transaction.getTimeout());
            handler.parameterize(stmt);
            this.currentSql = sql;
            this.currentStatement = ms;
            this.statementList.add(stmt);
            this.batchResultList.add(new BatchResult(ms,sql,parameterObject));
        }
        
        handler.batch(stmt);
        return -2147482646;
    }
    
##优缺点
优点：
1、利用模板方法将相同处理逻辑的代码放到抽象父类中，可以提高代码的复用性
2、将不同的代码放到不同的子类中，通过对子类的扩展增加新的行为，提高代码的扩展性。
3、把不变的行为写在父类上，去除子类的重复代码，提供了一个很好的代码复用平台，符合开闭原则。

缺点：
1、类数目的增加，每一个抽象都需要一个子类来实现，这样导致类的个数增加。
2、类数量的增加，间接地增加了系统实现的复杂度。
3、继承关系自身缺点，如果父类添加新的抽象方法，所有子类都要改一遍。