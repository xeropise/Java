package java8;

public class default_method {
	
    public interface Calculator {
        public int plus(int i, int j);
        public int multiple(int i, int j);
        default int exec(int i, int j){
            return i + j;
        }
        public static int exec2(int i, int j){   //static 메소드 
            return i * j;
        }
    }

  //인터페이스에서 정의한 static메소드는 반드시 인터페이스명.메소드 형식으로 호출해야한다.  
}
