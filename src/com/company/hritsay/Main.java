package com.company.hritsay;
import java.lang.reflect.*;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        try {
            Class c = Class.forName("com.basepackage.hobbies.Fishing");
            System.out.println("Полное мя класса: " + c.getName());
            System.out.println("Каноническое имя класса: " + c.getCanonicalName());
            System.out.println("Простое имя класса: " + c.getSimpleName());

            Constructor[] constructors = c.getConstructors();
            System.out.println("\nКонструкторы: ");
            for (Constructor constructor : constructors) {
                Class[] paramTypes = constructor.getParameterTypes();
                System.out.print("\t" + constructor.getName() + "(");
                for (Class paramType : paramTypes) {
                    System.out.print(paramType.getName() + ", ");
                }
                System.out.println(")");
            }

            System.out.println("\nМетоды класса: ");
            Method[] methods = c.getMethods();
            for (Method method : methods) {
                System.out.println("\nМетод: ");
                System.out.println("Имя: " + method.getName());
                System.out.println("Возвращаемый тип: " + method.getReturnType().getName());
                Class[] paramTypes = method.getParameterTypes();
                System.out.print("Типы параметров: ");
                for (Class paramType : paramTypes) {
                    System.out.print(" " + paramType.getName());
                }
                System.out.println();
            }

            System.out.println("Поля класса: ");
            Field[] fields = c.getDeclaredFields();
            for (Field field: fields) {
                System.out.println("\nПоле: ");
                System.out.println("Имя: " + field.getName());
                System.out.println("Тип: " + field.getType());
            }

            System.out.println("Вызов метода test(10, \"test\", 20.5) :");
        Method method = c.getMethod("test", int.class, String.class, double.class);
        Object []argus = {10, "test", 20.5f};
        method.invoke(c, argus);


            Field field = c.getDeclaredField("privateField");
            com.basepackage.hobbies.Fishing objectInstance = new com.basepackage.hobbies.Fishing();
            field.setAccessible(true);
            System.out.println("Работа  с полем privateField = " + objectInstance
                    + "\n Попробуем присвоить 44 ");
            field.setInt(objectInstance, 44);
            System.out.println("Поле privateField после присвоения = " + objectInstance);


        }  catch (NoSuchMethodException | NoSuchFieldException | SecurityException |
                IllegalAccessException | IllegalArgumentException |
                InvocationTargetException e) {
            e.printStackTrace();
        }




    }
}
