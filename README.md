# lab3
Чижевская Софья ПМ-2402. Вариант: 29
## Cодержание

1. [Отчет по лабораторной работе №](#отчет-по-лабораторной-работе--n)
2. [Критерии оценивания](#критерии-оценивания)

## Отчет по лабораторной работе № 3

#### № группы: `ПМ-2402`
#### Выполнил: `Чижевская Софья`
#### Вариант: `29`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

    Разработать программу для работы с массивом постов, где каждый пост содержит
    текст, автора и количество лайков. Реализовать функции добавления, удаления, анализа постов и обработки данных об авторах.
- Следует разработать класс onePost, в котором будут храниться данные о конкретном посте пользователя, включая имя автора, содержание поста и количество полученных лайков.

- В классе onePost необходимо реализовать методы для получения и установки значений (get и set).  

- Затем нужно создать класс AllPosts, который будет представлять собой массив всех постов пользователей.

- В классе AllPosts также нужно реализовать методы, указанные в задании.

- Наконец, необходимо создать класс Main, в котором будет проведена проверка правильности работы программы.
### 2. Входные и выходные данные
Программа должна инициализировать несколько переменных класса onePost и сформировать массив из них. 
Затем необходимо создать переменную класса AllPosts, которая будет ссылаться на ранее составленный массив. 
Различные методы будут выдавать разные типы данных, такие как int, String и OnePost, при этом в некоторых методах значения переменных могут изменяться, поэтому выходных данных не будет.

### 3. Выбор структуры данных
В программе задействованы два класса:
1. onePost: содержит поля для хранения имени пользователя (тип String), текста поста (тип String) и количества лайков (тип int).
2. AllPosts: хранит все посты в массиве фиксированной длины (в соответствии с ограничениями на использование динамических массивов), элементы которого имеют тип Account.
### 4. Алгоритм

1. **onePost**  
   - создание приватных полей этого класса
   - описание конструктора
   - описание подпрограммы по возвращению имени пользователя (обращение к полю)
   - описание подпрограммы по возвращению количества лайков (обращение к полю)
   - описание подпрограммы по добавлению лайка посту (обращение к полю типа int и увеличение его на 1)
   - описание подпрограммы toString
    
2. **AllPosts**  
    - Создание приватных полей для данного класса (метод включает максимальное количество записей, которое может быть сохранено в одной из этих переменных).

   - Конструктор (для вывода постов в порядке добавления массив инициализируется обратным образом).

   - подпрограмма добавления нового поста (необходимо переместить каждый пост на одну позицию вправо, а новый пост поместить в начало).

   -подпрограмма увеличения числа лайков у поста (обращение к посту по номеру и добавление лайка с помощью метода класса onePost).

   -подпрограмма получения количества лайков у поста (поиск поста по номеру и установка его количества лайков с помощью метода из класса onePost).

   -подпрограмма удаления поста (перемещение элементов массива, начиная с указанного номера, и замена последнего на null).

   -подпрограмма вывода постов с лайками выше заданного порога (перебор актуальных элементов и вывод постов с достаточным количеством лайков).

   -подпрограмма нахождения наиболее популярного поста (просмотр всех постов для определения максимального числа лайков).

   -подпрограмма вывода постов от одного автора (сравнение автора каждого поста с заданной строкой и вывод совпадающих постов).

   -подпрограмма удаления постов указанного автора (сравнение авторов и удаление постов, если их количество совпадает с заданным).

   -подпрограмма удаления всех постов конкретного автора (подсчет всех постов автора и их поэлементное удаление).

   -подпрограмма суммирования лайков у автора (сравнение авторов и прекращение цикла при совпадении).

   -подпрограмма вывода уникальных авторов (проверка на уникальность и формирование итогового списка).

   -подпрограмма подсчета самого популярного автора (обобщение лайков каждого автора и поиск автора с наибольшими лайками).

3. **Main**
  - создание переменных 
  - поочередная проверка каждого метода из класса AllPosts
### 5. Программа

```java
import java.io.PrintStream;
import java.util.Scanner;
class onePost {
   //создание первого класса, который будет хранить информация об одном посте(имя пользователя, текст поста, текущее количество лайков на нем
   private String name;// имя автора
   private String tekst; // текст автора
   private int like;// количество лайков

   //Конструктор класса, проверяющий на корректность данные для создания элемента, т.е. если имя автора не заполнено или введенный им текст больше 70 символов, то новый элемент не будет создан
   public onePost(String name, String tekst, int likes) {
      if (name.length() != 0)
         this.name = name;
      if (tekst.length() <= 70)
         this.tekst = tekst;
      this.like = likes;
   }

   //Подпрограмма для возвращения количества лайков пользователя, т.к. поля класса являются приватными
   public int getterOfLike() {
      return like;
   }

   //Подпрограмма для возвращения имени пользователя, т.к. поля класса являются приватными
   public String getterOfName() {
      return name;
   }

   //так как в задании есть требование добавления лайка человеку,то модно написать подрограмму для увелечения количества лайков на один
   public void AddOneLike(){
      like++;
   }

   //подпрограмма, позволяющая преобразовывать элемент в строку, чтобы можно было вывести его на экран
   @Override
   public String toString(){
      return ("Автор поста - "+name+"; Текст поста - "+tekst+"; Текущее количество лайков - "+like+"\n");

   }
}
class AllPosts {
   //создание класса для хранения всех постов на сайте
   private onePost[] posts = new onePost[30];//создание приватного поля для класса, т.к нельзя пользоваться динамическими массивами, то я создаю массив длины 30-это и будет максимально допустимое количество постов на сайте

   //Конструктор класса
   public AllPosts(onePost[] accounts) {
      int k = accounts.length;//т.к число аккаунтов внесенных при создании элемента может быть меньше чем длина массива в поле, то мы находим длину подаваемого и будем инициализировать массив нового элемента начиная с к-того элемента
      for (int i = k - 1; i >= 0; i--) {
         posts[i] = accounts[k - 1 - i];// т.к по заданию выводить элемента надо в обратном порядке, то начинаем инициализировать массив с конца подаваемого массива
      }
   }

   // 2. Добаление поста на сайт
   public void addPost(onePost post) {
      onePost t = posts[0];//т.к. Добавляемый элемент будет последним добавленным нам надо все элементы сместить на один,для этого надо запоминать предыдущий элемент
      for (int i = 1; i < posts.length; i++) {
         onePost tt = posts[i];
         posts[i] = t;
         t = tt;
         //теперь мы текущий элемент меняем на предыдущий и запоминаем текущий
      }
      posts[0] = post; // заменяем первый элемент(уже дубликат второго) на добавляемый элемент
   }

   // 3. добавление лайков посту
   public void addLiketoPerson(int t) {
      posts[t - 1].AddOneLike();//так как массив начинает счетчик с нуля, а пользователь с единицы, то надо вычесть из т единицу и добавить лайк этому посту
   }

   // 4. Возвращение количества лайков конкретного поста
   public int getterLikeOfPost(int t) {
      return posts[t - 1].getterOfLike();//так как массив начинает счетчик с нуля, а пользователь с единицы, то надо вычесть из т единицу и вернуть количество лайков под этим номером
   }

   // 5. Удаление поста по номер
   public void delitePost(int t) {
      for (int i = t - 1; i < posts.length - 1; i++) {
         posts[i] = posts[i + 1];// для удаления поста надо все посты начиная с указанного номера заменять на последующие
      }
      posts[posts.length - 1] = null;// если получится так что в массиве максимально возможное количество элементов, то последний элемент продублируется, поэтому последний элемент надо поменять на 0
   }

   // 6. Вывод постов с количеством лайков больше заданного
   public void moreLikethen(int t) {
      for (int i = 0; i < posts.length; i++) {
         if (posts[i] != null) { // проверка элемента массива на то, что он ненулевой
            if (posts[i].getterOfLike() > t) // если у того элемента больше лайков чем требуется, то он выводится на экран
               System.out.println(posts[i]);
         }

      }
   }

   // 7. Самый популярный пост
   public onePost mostPopular() {
      onePost t = posts[0];
      int max = 0;
      for (int i = 0; i < posts.length; i++) {
         if (posts[i] != null) { // проверка элемента массива на то, что он ненулевой
            if (posts[i].getterOfLike() > max) {// если количество лайков текущего поста меньше поста массива то происходит зпмена
               max = posts[i].getterOfLike(); // замена текущего максимума по количеству лайков
               t = posts[i]; // замена поста с максимальным количеством лайков
            }
         }
      }
      // реализация алгоритма по нахождению максимального элемента массива
      return t;
   }

   // 8. Посты определённого автора
   public void PostsofAvtor(String name) {
      for (int i = 0; i < posts.length; i++) {
         if (posts[i] != null) {// проверка элемента массива на то, что он ненулевой
            if (posts[i].getterOfName().equals(name))// если текущий поста имеет такого же автора как указанный то подпрограмма его выводит
               System.out.println(posts[i]);
         }

      }
   }

   // 9. Удаление поста по автору и номеру
   public void deliteAtorofN(String name, int t) {
      int kol = 0;// надо считать сколько раз уже встетился пост с определенным автором
      int index = -1;// индекс поста который надо удалить
      for (int i = 0; i < posts.length; i++) {
         if (posts[i] != null) {// проверка элемента массива на то, что он ненулевой
            if (posts[i].getterOfName().equals(name)) {// если текущий поста имеет такого же автора как указанный, то подпрограмма прибавляет счётчик
               kol++;
               if (kol == t) {//если счетчик сошелся с указанным количеством то запоминаем индекс
                  index = i;
               }
            }
         }
      }
      for (int i = index; i < posts.length - 1; i++) {
         posts[i] = posts[i + 1];
      }
      posts[posts.length - 1] = null;
      // принцип удаление поста такой же как и в подпрограмме 5
   }

   // 10. Удаление всех постов автора
   public void deliteAllAvtor(String name) {
      int reskol = 0;// счётчик количества встречаний автора
      for (int i = 0; i < posts.length; i++) {
         if (posts[i] != null) {
            if (posts[i].getterOfName().equals(name)) {
               posts[i]=null;//для удобства счета в следующем фор занулим элементы автора который нам не нужен
               reskol++;
            }
         }
      }
      // счетчик количества постов с указанным автором
      for (int i = 0; i < reskol; i++) {// надо удалить столько же элементов сколько былов счетчике
         int kol = 0;//счетчик количества появлений постов автора
         int index = posts.length; //надо находить индекс, под которым элемент который надо удалить
         for (int j = 0; j < posts.length - 1; j++) {
            if (posts[j]==null && kol == 0) { // находит первое встречание элемента
               kol++; // теперь кол не ноль, поэтому за этот проход больше не поменяется нужный индекс
               index = j;// меняем индекс
            }
            if (j >= index)
               posts[j] = posts[j + 1];
            // удаляем элемент про принципу описанному в 5 подпрограмме
         }
      }
   }

   // 11. Суммарное количество лайков автора
   public int sumLikeofAvtor(String name) {
      int sum = 0;//создание переменной для суммы лайков
      for (int i = 0; i < posts.length; i++) {
         if (posts[i] != null) {
            if (posts[i].getterOfName().equals(name)) {// если ненулевой элемент имеет имя нужного автора складывается сумма лайков
               sum += posts[i].getterOfLike();
            }
         }
      }
      return sum;
   }

   // 12. Список авторов сверху вниз
   public String allAvtors() {
      String s = "";//создание списка авторов
      for (int i = 0; i < posts.length; i++) {//так как нам надо найти уникальных авторов, то мы считаем колличество раз которое автор встречается от и-того элемента до начала списка
         if (posts[i] != null) {// проверяем что элемент не нулевой
            int kol = 0;//заводим счетчик элементов
            for (int j = i - 1; j >= 0; j--) {
               if (posts[j] != null)
                  if (posts[i].getterOfName().equals(posts[j].getterOfName()))
                     kol++;
            }// перебирвем элементы от и-того до нулевого, то прибавляем счетчик
            if (kol == 0)
               s += posts[i].getterOfName() + "\n";// если счётчик ноль, то элемент уникальны - значит можно занести имя в список
         }
      }
      return s;
   }

   // 13. Автор с наибольшим количеством лайков
   public String theMostPopularAvtor() {
      int maxsum = 0;
      onePost best = posts[0];
      for (int i = 0; i < posts.length; i++) {
         if (posts[i] != null) { // проверяем что элемент ненулевой
            int max = 0;//переменная для нахождения количества лайков
            for (int j = 0; j < posts.length; j++) {
               if (posts[j] != null) {
                  if (posts[j].getterOfName().equals(posts[i].getterOfName())) {
                     max += posts[j].getterOfLike();// если и-тый элемент и текущий имеют одинакового автора, то добавляем количество лайков
                  }
               }
            }
            if (max > maxsum) {
               maxsum = max;
               best = posts[i];//если количество лайков и-того автора больше максимального, то меняем лучшего автора
            }
         }
      }
      return best.getterOfName();
   }

   @Override
   public String toString() {
      String s = "";
      int kol = 0;
      for (int i = 0; i < posts.length; i++) {
         if (posts[i] != null)
            s += posts[i] + "\n";
         else
            kol++;
      }
      return s;
   }

}
public class Main {
   public static Scanner in = new Scanner(System.in);
   public static PrintStream out = System.out;

   public static void main(String[] args) {
      onePost p1 = new onePost("Соня", "Мандарин", 234);
      onePost p2 = new onePost("Дед мороз", "С новым годом", 23);
      onePost p3 = new onePost("Генадий", "утром вышло солнце", 5678);
      onePost p4 = new onePost("Генадий", "я ездил за елкой в лес", 4576);
      onePost p5 = new onePost("Соня", "как дела", 9);
      //создание пяти постов
      onePost p6 = new onePost("Соня", "Гирлянда", 123);
      //создание шестого поста для добавления
      onePost[] postss = new onePost[5];
      //создание массива с постами
      postss[0] = p1;
      postss[1] = p2;
      postss[2] = p3;
      postss[3] = p4;
      postss[4] = p5;

      AllPosts p = new AllPosts(postss);
      out.println("1.\n"+p); //проверка метода 1

      p.addPost(p6);
      out.println("2.\n"+p); //проверка метода 2

      p.addLiketoPerson(5);
      out.println("3.\n"+p);// проверка метода 3

      int like = p.getterLikeOfPost(3);
      out.println("количество лайков у поста номер 3:" + like); // проверка метода 4

      p.delitePost(5);
      out.println("5.\n"+p);// проверка метода 5

      out.println("6. лайков больше 100:");
      p.moreLikethen(100);// проверка метода 6

      out.println("7. самый популярныйй пост");
      out.println(p.mostPopular()); // проверка метода 7

      out.println("8. посты Сони:");
      p.PostsofAvtor("Соня");// проверка метода 8

      p.deliteAtorofN("Соня", 2);
      out.print("9.\n"+p);// проверка метода 9

      p.deliteAllAvtor("Геннадий");
      out.println("10.\n"+p); // проверка метода 10

      out.println("11. количество лайков у Сони - " + p.sumLikeofAvtor("Соня"));// проверка метода 11

      out.println("12. все авторы: \n" + p.allAvtors());// проверка метода 12

      out.println("13. автор с наибольшим количеством лайков - " + p.theMostPopularAvtor());// проверка метода 13
   }
}

```
### 5. Математическая модель

 В своей программе я не использую никаких формул

### 6. Анализ правильности решения
 Описание правильности решение приведено в классе Main 
                                                                                                                                                  


