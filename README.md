## kotlin 单列
### 饿汉式
```kotlin
object SimpleSington {
  fun test() {}
}
//在Kotlin里调用
SimpleSington.test()

//在Java中调用
SimpleSington.INSTANCE.test();
```

### 懒汉式
```kotlin
class LazySingleton private constructor(){
    companion object {
        val sInstance: LazySingleton by lazy { LazySingleton() }
    }
}
```
- 显式声明构造方法为private
- companion object用来在class内部声明一个对象
- LazySingleton的实例instance 通过lazy来实现懒汉式加载
- lazy默认情况下是线程安全的，这就可以避免多个线程同时访问生成多个实例的问题


### android空格符
```
&#32; == 普通的英文半角空格

&#160; == &nbsp; == &#xA0; == no-break space （普通的英文半角空格但不换行）

&#12288; == 中文全角空格 （一个中文宽度）

&#8194; == &ensp; == en空格 （半个中文宽度）

&#8195; == &emsp; == em空格 （一个中文宽度）

&#8197; == 四分之一em空格 （四分之一中文宽度）

相比平时的空格（&#32;），nbsp拥有不间断（non-breaking）特性。即连续的nbsp会在同一行内显示。即使有100个连续的nbsp，浏览器也不会把它们拆成两行。
```


1.DemoArithmetic :算法的demo
