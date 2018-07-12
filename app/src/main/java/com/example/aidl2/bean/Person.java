package com.example.aidl2.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String mName;
    public Person(String Name){
        mName = Name;
    }
    protected Person(Parcel in){
        mName = in.readString();
    }


    //实现类必须有一个 Creator 属性，用于反序列化，将 Parcel 对象转换为 Parcelable
    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };


    //描述当前 Parcelable 实例的对象类型
    //比如说，如果对象中有文件描述符，这个方法就会返回上面的 CONTENTS_FILE_DESCRIPTOR
    //其他情况会返回一个位掩码
    @Override
    public int describeContents() {
        return 0;
    }


    //将对象转换成一个 Parcel 对象
    //参数中 parcel 表示要写入的 Parcel 对象
    //i 表示这个对象将如何写入
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
    }
    @Override
    public String toString() {
        return "Person{" +
                "mName='" + mName + '\'' +
                '}';
    }
}

