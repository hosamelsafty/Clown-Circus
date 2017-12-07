package mvc.controller;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;


import mvc.model.Plate;


public class ClassLoading {
    private String path;
    private Constructor[] constructor;
    List<Class> clas = new ArrayList<>();

    public ClassLoading() {
        // this.path=path;
        File x = new File("Shapes");
        String[] databaseFiles = x.list();
        for (String s : databaseFiles) {
            File file = new File(x, s);

            try {
                URL url = file.toURI().toURL();
                URL[] urls = new URL[] { url };
                @SuppressWarnings("resource")
                ClassLoader cl = new URLClassLoader(urls);
                @SuppressWarnings("rawtypes")
                Class cls = cl.loadClass("Shapes." + s);
                clas.add(cls);
                constructor = cls.getConstructors();

            } catch (Exception e) {
            }
        }

    }

    public Plate getObject(int i, int x, int y, int delayedStart, boolean isLower) {
        // try {
        // Object object = constructor[0].newInstance( x,
        // y,delayedStart,isLower);
        // return (Plate) object;
        // } catch (Exception e) {
        // }
        // return null;
        Class otherShapeClass = clas.get(i);
        try {
            Plate tempShape = (Plate) otherShapeClass.newInstance();
            Constructor constructor = otherShapeClass.getDeclaredConstructor(int.class, int.class, int.class,
                    boolean.class);

            Plate shape = (Plate) constructor.newInstance(x, y, delayedStart, isLower);
            return shape ;
        } catch (Exception e) {
        }
        ;
        return null;

    }
}
