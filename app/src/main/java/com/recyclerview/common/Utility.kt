package com.recyclerview.common

import com.recyclerview.model.Person
import com.recyclerview.model.TabIndicatorModel

object Utility {

    fun getPerSonList(): ArrayList<Person> {
        val list = ArrayList<Person>()
        list.add(Person("Sateesh", 100, "abc@gmail.com"))
        list.add(Person("Ramesh", 101, "def@gmail.com"))
        list.add(Person("Kiran", 102, "ghi@gmail.com"))
        list.add(Person("Suman", 103, "jkl@gmail.com"))
        list.add(Person("Aadi", 104, "mno@gmail.com"))
        list.add(Person("Rahul", 105, "pqr@gmail.com"))
        list.add(Person("sundar", 106, "stu@gmail.com"))
        list.add(Person("kashi", 107, "vwx@gmail.com"))
        return list
    }

    fun getTabIndicatorModel(): ArrayList<TabIndicatorModel>{
        val list = ArrayList<TabIndicatorModel>()
        list.add(TabIndicatorModel(true))
        list.add(TabIndicatorModel())
        list.add(TabIndicatorModel())
        list.add(TabIndicatorModel())
        list.add(TabIndicatorModel())
        list.add(TabIndicatorModel())
        list.add(TabIndicatorModel())
        list.add(TabIndicatorModel())
        return list
    }
}