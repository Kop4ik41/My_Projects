package ru.rut_miit.lab1cdispring.SortingMethods;

import java.util.List;


public interface ICollectionSorter {
    <T extends Comparable<? super T>> void sort(List<T> list);
}
