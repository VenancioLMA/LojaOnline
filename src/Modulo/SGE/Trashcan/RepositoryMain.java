//package Modulo.SGE.Trashcan;
//
//import Modulo.Commons.Interfaces.IRepository;
//
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class RepositoryMain<T> implements IRepository<T> {
//    protected final List<T> dataStore = new ArrayList<>();
//
//    @Override
//    public T add(T i) {
//        dataStore.add(i);
//        return i;
//    }
//
//    @Override
//    public boolean remove(int id) {
//        return dataStore.removeIf(item -> hasMatchingField(item, param));
//    }
//
//    @Override
//    public T update(int id, Object newValue) {
//        for (T item : dataStore) {
//            if (hasMatchingField(item, param)) {
//                return updateField(item, param, newValue);
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public T listOne(int id) {
//        return dataStore.stream().filter(item -> hasMatchingField(item, param)).findFirst().orElse(null);
//    }
//
//    @Override
//    public List<T> listAll() {
//        return new ArrayList<>(dataStore);
//    }
//
//    private boolean hasMatchingField(T item, Object key) {
//        try {
//            for (Field field : item.getClass().getDeclaredFields()) {
//                field.setAccessible(true);
//                if (Objects.equals(field.get(item), key)) {
//                    return true;
//                }
//            }
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    private T updateField(T item, Object key, Object newValue) {
//        try {
//            for (Field field : item.getClass().getDeclaredFields()) {
//                field.setAccessible(true);
//                if (Objects.equals(field.get(item), key)) {
//                    field.set(item, newValue);
//                    return item;
//                }
//            }
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
