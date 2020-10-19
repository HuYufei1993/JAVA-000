import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义classloader
 * @author hyf
 * @date 2020-10-18
 */
public class MyClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(name);
        byte[] buf = null;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            buf = new byte[inputStream.available()];
            inputStream.read(buf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0; i<buf.length; i++){
            buf[i] = (byte)(255 - buf[i]);
        }
        Class clazz = this.defineClass("Hello",buf,0,buf.length);
        return clazz;
    }

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException,
            InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class clazz = myClassLoader.findClass("/Users/huyufei/Documents/java_lesson/code/src/Hello.xlass");
        Method method = clazz.getMethod("hello");
        Object obj = clazz.newInstance();
        method.invoke(obj);
    }
}
