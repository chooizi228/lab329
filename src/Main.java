
import java.io.PrintStream;
import java.util.Scanner;


class onePost {
    //создание первого класса, который будет хранить информацию об одном посте(имя пользователя, текст поста, текущее количество лайков на нем
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

    //так как в задании есть требование добавления лайка человеку,то можно написать подрограмму для увелечения количества лайков на один
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
        int k = accounts.length;//так как число аккаунтов внесенных при создании элемента может быть меньше чем длина массива в поле, то мы находим длину подаваемого и будем инициализировать массив нового элемента начиная с к-того элемента
        for (int i = k - 1; i >= 0; i--) {
            posts[i] = accounts[k - 1 - i];// так как по заданию выводить элементы надо в обратном порядке, то начинаем инициализировать массив с конца подаваемого массива
        }
    }
    // 2. Добаление поста на сайт
    public void addPost(onePost post) {
        onePost t = posts[0];//так как добавляемый элемент будет последним добавленным нам надо все элементы сместить на один, для этого надо запоминать предыдущий элемент
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

    // 5. Удаление поста по номеру
    public void deletePost(int t) {
        for (int i = t - 1; i < posts.length - 1; i++) {
            posts[i] = posts[i + 1];// для удаления поста надо все посты начиная с указанного номера заменять на последующие
        }
        posts[posts.length - 1] = null;// если получится так что в массиве максимально возможное количество элементов, то последний элемент продублируется, поэтому последний элемент надо поменять на 0
    }

    // 6. Вывод постов с количеством лайков больше заданного
    public void moreLikethan(int t) {
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
                if (posts[i].getterOfLike() > max) {// если количество лайков текущего поста больше максимума, то происходит замена
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
                if (posts[i].getterOfName().equals(name))// если текущий поста имеет такого же автора как указанный, то подпрограмма его выводит
                    System.out.println(posts[i]);
            }

        }
    }

    // 9. Удаление поста по автору и номеру
    public void deleteAtorofN(String name, int t) {
        int kol = 0;// надо считать сколько раз уже встретился пост с определенным автором
        int index = -1;// индекс поста который надо удалить
        for (int i = 0; i < posts.length; i++) {
            if (posts[i] != null) {// проверка элемента массива на то, что он ненулевой
                if (posts[i].getterOfName().equals(name)) {// если текущий поста имеет такого же автора как указанный, то подпрограмма прибавляет счётчик
                    kol++;
                    if (kol == t) {//если счетчик сошелся с указанным количеством, то запоминаем индекс удаляемого поста
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
    public void deleteAllAvtor(String name) {
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
        for (int i = 0; i < reskol; i++) {// надо удалить столько же элементов сколько было в счетчике
            int kol = 0;//счетчик количества появлений постов автора
            int index = posts.length; //надо находить индекс, под которым элемент, который надо удалить

            for (int j = 0; j < posts.length - 1; j++) {
                if (posts[j]==null && kol == 0) { // находит первое встречание элемента
                    kol++; // теперь кол не ноль, поэтому за этот проход больше не поменяется нужный индекс
                    index = j;// меняем индекс
                }
                if (j >= index)
                    posts[j] = posts[j + 1];
                // удаляем элемент по принципу описанному в 5 подпрограмме
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
        for (int i = 0; i < posts.length; i++) {//так как нам надо найти уникальных авторов, то мы считаем количество раз которое автор встречается от и-того элемента до начала списка
            if (posts[i] != null) {// проверяем что элемент не нулевой
                int kol = 0;//заводим счетчик элементов
                for (int j = i - 1; j >= 0; j--) {
                    if (posts[j] != null)
                        if (posts[i].getterOfName().equals(posts[j].getterOfName()))
                            kol++;
                }// перебираем элементы от и-того до нулевого, прибавляем счетчик
                if (kol == 0)
                    s += posts[i].getterOfName() + "\n";// если счётчик ноль, то элемент уникальнен - значит можно занести имя в список
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
        for (int i = 0; i < posts.length; i++) {
            if (posts[i] != null)
                s += posts[i] + "\n";
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
        onePost p3 = new onePost("Геннадий", "утром вышло солнце", 5678);
        onePost p4 = new onePost("Геннадий", "я ездил за елкой в лес", 4576);
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
        out.println("количество лайков у поста номер 3: " + like); // проверка метода 4

        p.deletePost(5);
        out.println("5.\n"+p);// проверка метода 5

        out.println("6. лайков больше 100:");
        p.moreLikethan(100);// проверка метода 6

        out.println("7. самый популярный пост");
        out.println(p.mostPopular()); // проверка метода 7

        out.println("8. посты Сони:");
        p.PostsofAvtor("Соня");// проверка метода 8

        p.deleteAtorofN("Соня", 2);
        out.print("9.\n"+p);// проверка метода 9

        p.deleteAllAvtor("Геннадий");
        out.println("10.\n"+p); // проверка метода 10

        out.println("11. количество лайков у Сони - " + p.sumLikeofAvtor("Соня"));// проверка метода 11

        out.println("12. все авторы: \n" + p.allAvtors());// проверка метода 12

        out.println("13. автор с наибольшим количеством лайков - " + p.theMostPopularAvtor());// проверка метода 13
    }
}