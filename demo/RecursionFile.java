package recursion;

import java.io.File;

//新建NewTestFile类
public class NewTestFile {
    //设计一个方法遍历文件夹
    // 构造方法showFile，调用API类File，file->参数（代表文件或者文件夹）
    public void showFile(File file) {
        //获取file的子元素，jdk的构造方法：listFiles()，接收返回值的类型File[]，参数files，
        File[] files = file.listFiles();
        //如果file是非空文件夹,&&前面为假是后面的不执行，避免异常发生
        if (files != null && files.length != 0) {
            for (File f : files) {
                this.showFile(f);
            }
        }
        /*直接显示路径（file是文件或file是一个空的文件夹），
        调用File类的参数getAbsolutePath(),返回文件或者文件夹的路径
        */
        System.out.println(file.getAbsolutePath());
    }

    public static void main(String[] args) {

        NewTestFile newTestFile = new NewTestFile();
        File file = new File(
                "D://BaiduNetdiskDownload//Java//javaProgram//点菜系统");
        newTestFile.showFile(file);
    }
}