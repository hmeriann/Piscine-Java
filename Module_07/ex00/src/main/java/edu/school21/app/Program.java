package edu.school21.app;

import edu.school21.classes.Car;
import edu.school21.classes.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


public class Program {
    private static final String PACKAGE = "edu.school21.classes.";
    private static final String BORDER = "---------------------";
    public static void main(String[] args) throws ClassNotFoundException {
        Program program = new Program();
        Car car = new Car();
        User user = new User();

        System.out.println("Classes:");
        program.showClassName(user);
        program.showClassName(car);
        System.out.println(BORDER);

        System.out.println("Enter class name:");
        System.out.print("->");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.next();
        System.out.println(BORDER);

        try {
            Class aClass = Class.forName(PACKAGE + className);
            program.showClassFieldsMethods(aClass);
            System.out.println(BORDER);

            program.createObject(aClass);
            System.out.println(BORDER);

            program.changeObject(aClass);
            System.out.println(BORDER);

            program.callMethod(aClass);
            System.out.println(BORDER);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
    public void showClassName(Object object) {
        Class cl = object.getClass();
        System.out.println(cl.getName().substring(21));
    }

    public void showClassFieldsMethods(Class aClass) {

        System.out.println("fields :");
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields)
            System.out.println("\t" + field.getType().getSimpleName() + "\t" + field.getName());

        System.out.println("methods:");
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print("\t" + method.getName() + "(");
            Type genericParameterTypes[] = method.getGenericParameterTypes();

            if (genericParameterTypes.length == 0) {
                System.out.println(")");
                continue;
            }
            for (int i = 0; i < genericParameterTypes.length; i++) {
                String[] currType = genericParameterTypes[i].getTypeName().split("\\.");
                if (i == genericParameterTypes.length - 1) {
                    System.out.println(currType[currType.length - 1] + ")");
                } else {
                    System.out.println(currType[currType.length - 1] + ", ");
                }
            }
        }
    }

    public void createObject(Class aClass) throws InstantiationException, IllegalAccessException {
        System.out.println("Let's create an object.");
        Field[] fields = aClass.getDeclaredFields();

        Object object = aClass.newInstance();
        for (Field field : fields) {
            Object val = null;
                System.out.print(field.getName() + ":\n->");
                Scanner scanner = new Scanner(System.in);
                val = castValue(field.getType().getSimpleName(), scanner.nextLine());
                field.setAccessible(true);
                try {
                    field.set(object, val);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("Object created: " + object);

    }

    private Object castValue(String typeName, String val) {
        try {
            switch (typeName) {
                case "Integer":
                    return (Integer.parseInt(val));
                case "Long":
                    return (Long.parseLong(val));
                case "Boolean":
                    return (Boolean.parseBoolean(val));
                case "Float":
                    return (Float.parseFloat(val));
                case "Double":
                    return (Double.parseDouble(val));
                case "Short":
                    return (Short.parseShort(val));
                case "String":
                    return (val);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println("Cannot cast " + val);
            return null;
        }
    }


    public void changeObject(Class aClass) throws InstantiationException, IllegalAccessException {
        System.out.println("Enter name of the field for changing:");
        Field[] fields = aClass.getDeclaredFields();

        System.out.print("->");
        Scanner scanner = new Scanner(System.in);
        String fieldName = scanner.next();

        Object object = aClass.newInstance();
        for (Field field : fields) {
            if (fieldName.equals(field.getName())) {

                System.out.println("Enter " + field.getType().getSimpleName() + " value:");
                System.out.print("->");
                Scanner scanner1 = new Scanner(System.in);
                String fieldVal = scanner1.next();
                field.setAccessible(true);
                try {
                    field.set(object, fieldVal);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No such field for the object: " + fieldName);
                break;
            }
        }
        System.out.println("Object updated: " + object);

    }

    public void callMethod(Class aClass) throws InstantiationException, IllegalAccessException {
        System.out.println("Enter name of the method for call:");
        Method[] methods = aClass.getDeclaredMethods();

        System.out.print("->");
        Scanner scanner = new Scanner(System.in);
        String methodName = scanner.next();

        for (Method method : methods) {
            if (methodName.equals(method.getName())) {

//                System.out.println("Enter " + method.getGenericParameterTypes().() + " value:");
                System.out.print("->");
                Scanner scanner1 = new Scanner(System.in);
                String fieldVal = scanner1.next();
                method.setAccessible(true);
//                try {
//                    method.set(object, fieldVal);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
            } else {
                System.out.println("No such field for the object: " + methodName);
                break;
            }
        }
//        System.out.println("Object updated: " + object);

    }
}
