# 第十章：内部类
## 10.1 创建内部类
直接在外围类中声明。
## 10.2 链接到外部类
每个非static的内部类都隐含地包含着一个外围类的应用，使得通过这个内部类可以修改外围类的属性。
## 10.3 使用.this和.new
+ 内部类中的方法中使用 外围类名称+.this （例如 xx.this）可以获取其外围类的引用。
+ 想要创建一个内部类的实例，必须要先生成一个外部类的对象，使用这个对象来创建内部类。
**例如：**
```
Apple apple = new Apple();
Apple.Core core = apple.new Core();
```
## 10.4 内部类与向上转型
内部类向上转型为其基类或接口（private的内部类不能从外部访问），使用方法与普通类的向上转型类似。
## 10.5 在方法与作用中的内部类
之前的内部类使用均是内部类功能的特例。一般内部类在如下几种情况中使用：
  1. 一个定义在方法中的类或者一个定义在作用域内的类，作用域在方法内部
  2. 一个实现了接口的匿名类
  3. 一个匿名类，拓展了有非默认构造器的类
  4. 一个匿名类，执行字段初始化
  5. 一个匿名类，通过实例初始化实现构造
## 10.6 匿名内部类
匿名类功能与产生一个新的继承现有类的类相同，只是不含有类名。例如：
```
public class Pacel {
  public Contents contents() {
    return new Content() {
      private int i = 1;
      public int value() {
        return i;
      }
    }
  }
}
```
如果需要匿名类的构造函数有参数：
```
public Contents contents(int val) {
  return new Content(val) {  //Pass the arguments here.
    public int value() {
      return super.value();
    }
  }
}
```

如果希望匿名类使用在其外部定义的对象，传入值时一定要使用final关键字

## 10.6 基于内部匿名类的工厂方法实现
## 10.7 嵌套类
如果不需要内部类对象与外围类对象之间有联系，可以将内部类声明为static，这通常被称为**嵌套类**。这意味着：
  1. 创建嵌套类的对象不需要外围类实例
  2. 不能再嵌套类的对象中访问非静态的外围类变量

### 接口内部的类
因为接口中声明的方法都是static与public的，所以将嵌套类置于接口的命名空间内不违反接口的规则。

**举例：**
```
public interface ClassInterface {
  void func();
  class Test implements ClassInterface {
    public void func() {
      System.out.println("Func test!");
    }
    public static void main(String[] args) {
      new Test.func();
    }
  }
}
```
这样可以在使得某个接口的所有实现共用其内部类的共用代码。

### 多重嵌套类访问外部类的成员
内部类嵌套多少层都可以透明地访问其外围类中的所有成员。

## 10.8 内部类的作用
1. 多重继承：
```
class D() {}
abstract class E {}
class C extends D {
  E makeE() {
    return new E() {};
  }
}
```
2. **其他特性：**
    + 内部类可以有多个实例，每个实例有自己的状态信息
    + 在单个外围类中，可以让多个内部类以不同方式实现同一个接口，或继承同一个类
    + 创建内部类的时刻不依赖与外部类的创建时刻
    + 内部类是一个独立的实体，不是is-a关系

## 10.8 闭包与回调

## 10.9 控制框架系统
控制框架是一类特殊的应用程序框架，用来解决响应事件的需求。（主要用来响应事件的系统被称为**事件驱动系统**）


# 第十一章：持有对象
## 11.1 泛型和类型安全的容器
ArrayList<Apple> 指定此arraylist中的数据类型，Apple子类也可以通过向上转型加入其中。
## 11.2 基本概念
Java容器类类库划分为两个概念：
1. Collection--独立元素的序列，这些元素服从一条或多条规则。<br>**举例**：
    - LIst--按插入顺序保存
    - Set--不能有重复元素
    - Queue、Stack、Heap
2. Map--存贮**键值对**。Map可以称为字典。

## 11.3 添加一组元素
Collection的构造器可以接受另一个Collection，用它来完成自身初始化。
collection.addAll()成员方法只能接受另一个Collection对象作为参数。

## 11.4 容器的打印
参考Python中的list和dictionary的形式。（可以修改toString()方法来控制打印结果）

************
## 11.5 List
**分为两种类型的List：**
1. 基本ArrayList，随机访问元素，在List中间插入和移除元素时较慢
2. LinkedList，在List中间插入和移除元素时代价较低，提供了优化的顺序访问

## 11.6 迭代器Iterator
  + boolean hasNext()
  + Object next()
  + void remove()

## 11.7 LinkedList
可以用作栈、队列、双端队列。
  + add(E e) = addFirst(E e) , addLast(E, e) , add(int index, E e)
  + E remove() = E removeFirst(), E removeLast(),E remove(int index), boolean remove(Object o)
  + 其他功能参考Stack、Queue、Deque的函数
## 11.8 Stack
由于版本原因，可以用LinkedList产生更好的Stack

## 11.9 Set
主要使用contains()方法保证Set中无重复元素
## 11.10 Map
+ 其中的key和val不能使用基本类型（int -> Integer, char -> Character）
+ 通过把key-value中的value设定为Map，可以将此种数据结构拓展为多维情形。（和其他容器Collection一样）
+ Map可以返回它的键的Set(Set<K> keySet())，它的值的Collection(Collection<V> values)，或所有键值对的Set

## 11.11 Queue
FIFO容器。可以由LinkedList向上转型得到Queue接口的一个实例。
+ offer() 将一个元素插入到队尾
+ peek() 与 element()在不移除情况下返回队头
+ poll() 与 remove()方法移除并返回队头

### 11.11.1 PriorityQueue
优先队列（Heap），其弹出的下一个元素具有最高的优先级
+ 使用peek()、poll()、remove()时获取PQ中优先级最高的元素
+ 使用offer()来插入一个元素
+ 可以通过传入自己构造的Comparator来改变优先级的定义
+ Integer、Character、String已经有默认的优先级顺序，传入Comparator可以改变

## 11.12 Collection与Iterator
## 11.13 Foreach与迭代器
对所有Iterable类型的数据结构，用for(:)遍历
### 11.13.1 适配器方法
eg:使用适配器方法将原有迭代器转换为反方向迭代器
```
public Iterable<T> reversed() {
  return new Iterable<T> {
    public Iterator<T> iterator() {
      return new Iterator<T>() {
        int current = size() - 1;
        public boolean hasNext() {
          return current > -1;
        }
        public T next() {
          return get(current --);
        }
        public void remove() {
          throw new UnsupportedOperationException();
        }
      };
    }
  };
}
```
**TIPS：**
直接使用List<Integer> list1 = Array.asList(arrayName)会直接使用底层数组作为其物理实现，改变list1中元素会影响原来的arrayName数组

而使用形如List<Integer> list2 = new Array.asList(arrayName)则是将Array.asList(arrayName)作为输出构造了一个新的ArrayList

## 11.14 总结
**TIPS：**
1. HashMap用来快速访问，TreeMap保持键始终处于排序状态，LinkedHashMap保持元素插入顺序，也通过散列提供了快速访问能力
2. 新程序最好不再使用Vector、Stack、HashTable等元素


# 第十三章：字符串
## 13.1 不可变String
String对象是不可变的。例如s.toUpperCase()或s.substring()都只会返回一个新的对象
## 13.2 重载“+”与StringBuilder
String的"+"和"+="是Java中仅有的两个重载的运算符。

使用javap（-c 生成Java字节码）反编译该过程，发现编译器会自动引用StringBuilder来完成将原有字符串连接为新字符串的功能。

**TIPS：**如果涉及到的字符串连接较复杂，可以手动创建StringBuilder来完成新的字符串的构造，避免使用“+”每次都新实例化一个StringBuilder

## 13.3 无意识递归
由于“+”会调用非String数据类型的toString()方法，所以需要避免toString()方法陷入死循环。
例如：
```
public class Infinite {
  public String toString() {
    return "String:" + this +　"\n";
  }
}
```
其中“+”会调用之后this.toString()方法，使得陷入toString()死循环

## 13.4 String的操作
参见JDK文档
## 13.5 格式化输出
### **Formatter类**
Java中所有格式化功能由java.util.Formatter类处理。
<!-- TODO:Complete the concrete document for format -->

## 13.6 正则表达式
+ string.match("")
+ string.split("")

### 13.6.2 创建正则表达式
java.util.regex.Pattern中可以查询
### 13.6.3 量词
1. 贪婪型：尽可能多的匹配
2. 勉强（懒惰）型：尽可能少的匹配（通过在贪婪型后加上“？”实现）
3. 占有型：**(只在Java中使用)**

语法举例：
|Regex    |Meaning|
|:--------|:------|
| X?      | 0-1个X |
| X*      | 0-n个X |
| X+      | 1-n个X |
| X{n}    | 恰好n个X |
| X{n,}   | 至少n个X |
| X{n,m}  | 至少n个X，不超过m个 |
### 13.6.4 Pattern和Matcher
使用正则表达式编译一个Pattern对象
+ 使用static Pattern.compile()方法编译正则表达式
+ 将想要检索的字符串传入Pattern的matcher()方法，matcher()会自动生成一个Matcher对象

**eg：**
```
Matcher m = Pattern.compile("\\w+").matcher("aabbccd");
```
find()可以在输入的任何位置定位正则表达式，而lookingAt()和matches()只有在正则表达式与输入的最开始处就开始匹配。
find()发现匹配后，m.group()中既是发现的匹配字符串。（参考Iterator的hasNext与next）

**eg:**
```
Pattern p = Pattern.compile("xxx", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE)
Matcher m = p.matcher("xxxx" + "xxxx");
while (m.find()) {
    System.out.println(m.group());
}
```
其中Pattern中的参数可以控制编译正则表达式的方式
### 13.6.5 Pattern的split()方法
```
String input = "xxlsdjfkl0-324((_#))"
Pattern.compile("xxx").split(input);
//Or Pattern.compile("xxx").split(input, 5);
//其中的数字参数控制分割后每个子字符串的长度
```

### 13.6.6 替换操作
+ string.replaceFirst("regex", "the string")
+ string.replaceAll("regex", "the string")
+ **Important:可以对每个替换位置进行特殊操作**: matcher.appendReplacement()
**eg:**
```
StringBuffer sbuf = new StringBuffer();
while (m.find()) {
  m.appendReplacement(sbuf, m.group().toUpperCase());
}
m.appendTail(sbuf);
```
遍历执行替换，最终将未处理部分加入sbuf
***********
### 13.6.7 reset()
matcher.reset("new input")可以让matcher匹配新的字符串

## 13.7 扫描输入
### Java的Scanner类：
Scanner定界符：
+ 默认情况下根据空白字符对输入进行分词
+ 可以使用scanner.useDelimiter("regex")来指定自己所需的定界符。使用正则表达式来分割读取到的输入
+ 可以用useDelimiter()来设置定界符，还有delimiter()方法来返回当前作为定界符的Pattern对象
### 用正则表达式扫描：
**eg:**
```
String pattern = "regex";
while(scanner.hasNext(pattern)) {
  scanner.next(pattern);
  MatchResult match = scanner.match();
}
```
调用next()方法可以到达下一个匹配regex的字符串位置，使用match()方法获取该匹配的字符串

### 13.8 StringTokenizer
和使用Scanner与正则表达式来采用更加复杂的模式可以分割字符串。

*********************

# 第十四章：类型信息
## 14.1 RTTI简介
在运行时，识别一个对象的类型。
比如Shape有子类Circle、Rectangle、Triangle。使用Shape s = new Circle();
使用RTTI，可以查询某个Shape引用所指向的具体数据类型。
## 14.2 Class对象
每当编写并编译了一个新的类，都会生成一个对应的Class对象（.class同名文件）。
JVM将使用“类加载器”子系统来生成这个类的对象。

类加载器子系统包含一条类加载器链，但只有一个原生类加载器。（原生类加载器加载**可信类**，包括Java API类）通常不必添加额外的类加载器到加载器链上，除非有类似支持Web服务器应用等特殊需求。

所有的类在对其进行第一次使用时，动态加载到JVM中（因为类的构造器也是静态方法）。

Java的Class类（所有Class对象属于Class类）提供了static方法forName(),用包含目标类的文本名的String作为输入参数，返回一个Class对象的应用。（可用于动态加载类）

属于Object的getClass()方法：（对于一个Class c 及c的一个实例ceg）
+ ceg.getClass() 和 c.class均可以获得c这个类
+ c.getSuperclass()可以获得c的基类
+ 使用for(Class i : c.getInterfaces) {}可获得c的全部接口
+ c.newInstance()可以生成一个新的类c实例（需要有**默认**构造方法）

### 14.2.1 类字面常量
使用类名.class可以直接获得对Class对象的引用，即使用**类字面常量**（如c.class)

为使用类做的准备工作：
1. 加载，找到字节码（通常在classpath指定路径），并从这些字节码创建一个Class对象
2. 链接，验证类中的字节码，为静态域分配储存空间，如果必须，解析这个类的创建对其他类的所有引用
3. 初始化，如果此类有超类，对其初始化，执行静态初始化器和静态初始化块。

类中的static final值是“编译期常量”，不需要对类进行初始化就可获得，非编译期常量则需要。
一个static域不是final的，对它进行访问时，要先进行链接（为这个域分配存储空间）和初始化（初始化该存储空间）。

### 14.2.2 泛化的Class引用
可以在Class后加上类型信息来利用编译器作类型检查。例如：
```
Class<? extends Number> a = int.class;
```

## 14.3 类型转换前先做检查
RTTI形式：
1. 传统类型转换，“(Shape)”
2. 代表对象类型的Class对象，通过Class获取运行时所需信息
3. 关键字instanceof，例如"if(x instanceof Dog)"
<!-- TODO: How to use RTTI for more function -->



# 泛型
## 15.2 简单泛型
泛型的意义：为了创造**容器类**
### 15.2.1 元组类库（Tuple）
作用：return多个对象，例如Python中return (a,b,c)
例子(二元元组与继承它的三元元组)：
```
public class TwoTuple<A, B> {
  public final A first;
  public final B second;
  public TwoTuple(A a, B b) {
    first = a;
    second = b;
  }
  public toString() {
    return "xxx";
  }
}
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
  public final C third;
  public ThreeTuple(A a, B b, C c) {
    supber(a, b);
    third = c;
  }
}//类似地，可以构造n元元组
```
### 15.2.2 堆栈类
实现：
```
public class LinkedStack<T> {
  private static class Node<U> {
    U item;
    Node<U> next;
    Node() {
      this.item = null;
      this.next = null;
    }
    Node(U item, Node<U> next) {
      this.item = item;
      this.next = next;
    }
  }
  private Node<T> top = new Node<T>();
  public void push(T t) {
    if (this.top.item == null) {
      this.top.item = t;
    } else {
      Node<T> nextNode = New Node<T>();
      nextNode.next = this.top;
      this.top = nextNode;
      this.top.item = t;
    }
  }
  public T pop() {
    T stackPop = this.top.item;
    Node<T> oldTop = this.top;
    if (this.top.next != null) {
      this.top = this.top.next;
      oldTop = null;
    } else {
      this.top.item = null;
    }
    return stackPop;
  }
}
```

## 15.3 泛型接口
## 15.4 泛型方法
+ 特点：使得该方法可以独立于类而产生变化
+ 要求：如果泛型方法可以取代整个类的泛化，尽量使用泛型方法
+ 特点：对于一个static的方法，无法访问泛型类的类型参数，故要使得static方法使用泛型能力，必须使其成为泛型方法

应用举例：（只需把泛型参数列表置于返回值前）manup
```
public <T> void f(T x) {
  System.out.println(x.getClass().getName());
}
```
+ 特点：使用泛型类时，通常可以不指明参数类型，编译器会为我们找到具体的类型。如果调用方法时传入基本类型，则基本类型会被自动打包为对应的对象


## 15.7 擦除
Java中，在泛型代码内部，无法获得任何有关泛型参数类型的信息。

正在使用泛型时，任何具体的类型信息都被擦除了，例如List<String>和List<Integer>都被擦除成其原生类型List

**重点：** 协助泛型类，给定泛型类的边界，例如<T extends Shape>可以告诉编译器只能接受遵循这个边界的类型。 例如List<T extends Shape>在被进行擦除时，T被擦除到了Shape


## 15.12 自限定类型




*****************
