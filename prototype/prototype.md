#原型模式

##定义
 原型模式是指原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 
##适用场景
 1、类初始化消耗资源较多
 2、new 产生的一个对象需要非常繁琐的过程（数据准备、访问权限等）
 3、构造函数比较复杂
 4、循环体中生产大量对象时。
 
 在Spring中，原型模式应用得也是非常广泛。例如：scope = "prototype"。我们经常用JSON。parseObject()也是一种原型模式。
 
### 简单克隆
 一个标准得原型模式得设计思路如下：
   1、先创建原型Prototype接口
   2、创建具体需要克隆得对象 ConcretePrototype
   3、创建Client对象
   
   当我们复制得不是值，而是引用地址得时候，我们如果修改任意一个对象中得属性值，其相应得对象地值都会改变，这就是我们常说
   地浅克隆。只是完整复制了值类型数，没有赋值引用对象。
   
###深度克隆
   例如：孙悟空吹毫毛

###克隆破坏单例模式
   如果我们克隆的目标的对象是单例对象。意味着，深克隆就会破坏单例。实际上防止克隆破坏单例解决思路非常简单，禁止深度克隆
   便可。
   
###Cloneable 源码分析
   ArrayList就实现了Cloneable接口。
   以下为clone（）方法
   
    public Object clone(){
        try{
            ArrayList<?> v = (ArrayList<?>)super.clone();
            v.elementData = Arrays.copyOf(elementData,size);
            v.modCount = 0;
            return v;
        }carch(CloneNotSupportedException e){
            throw new InternalError(e);
        }
    }