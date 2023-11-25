package com.lab;

public class SingletonRepository {
    //Lazy implementation

    private static volatile SingletonRepository instance;

    private SingletonRepository() {
    }

    public static SingletonRepository getInstance() {
        if (instance == null) {
            synchronized (SingletonRepository.class) {
                if (instance == null) {
                    instance = new SingletonRepository();
                }
            }
        }
        return instance;
    }

    //Other ways of implementation
    //1. Eager initialisation

    //This singleton can be impacted by
    //1. Cloning
    //2. Serialisation
    //3. Reflection

}
