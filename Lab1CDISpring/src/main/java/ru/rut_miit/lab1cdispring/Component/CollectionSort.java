package ru.rut_miit.lab1cdispring.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.rut_miit.lab1cdispring.Interceptors.ProfileInterceptor;
import ru.rut_miit.lab1cdispring.SortingMethods.ICollectionSorter;


import java.util.List;


@Service
public class CollectionSort<T> {

    @Value("${serviceName}")
    private String serviceName;

    private ICollectionSorter collectionSorter;

    @Autowired
    public void setCollectionSorter(ApplicationContext context) {
        collectionSorter = (ICollectionSorter) context.getBean(serviceName);
    }
/*    @Autowired
    @Qualifier("heap")
    private ICollectionSorter collectionSorter;*/

    @Autowired
    ProfileInterceptor profileInterceptor; // Перехватчик

    public String getServiceName() {
        return serviceName;
    }

    public  <T extends Comparable<? super T>> void sort(List<T> list) {
        collectionSorter.sort(list);
    }
}
