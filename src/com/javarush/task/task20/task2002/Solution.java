package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("data_test","task2002",new File("D:/"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
           // javaRush.users.add(user);
           // javaRush.users.add(user);
            user.setFirstName("Vlad");
            user.setLastName("Okhrimenko");
            GregorianCalendar calendar = new GregorianCalendar(1985,5-1,30);
            user.setBirthDate(calendar.getTime());
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.save(outputStream);
            outputStream.flush();
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            System.out.println(loadedObject.users.size());
       /*    User userTest = loadedObject.users.get(0);
            System.out.println(userTest.getFirstName());
            System.out.println(userTest.getLastName());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            System.out.println(dateFormat.format(userTest.getBirthDate())) ;
            System.out.println(userTest.isMale());
            System.out.println(userTest.getCountry().toString());
*/
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (!users.isEmpty()){
                User user;
                for (int i=0;i<users.size();i++){
                    user=users.get(i);
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(user.getBirthDate().getTime());
                    printWriter.println(user.isMale());
                    printWriter.println(user.getCountry().getDisplayedName());
                }
            }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String value =null;
            while (reader.ready()) {
                  User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    value = reader.readLine();
                    if (value.equals("Russia")) {
                        user.setCountry(User.Country.RUSSIA);
                    } else if (value.equals("Ukraine")) {
                        user.setCountry(User.Country.UKRAINE);
                    } else if (value.equals("Other")) {
                        user.setCountry(User.Country.OTHER);
                    }
                    users.add(user);
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
