package csc3020.lecture21.gr4381;

public class MyClass implements Comparable<MyClass>{
    private String label, value;

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public MyClass(String label, String value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
//        return Objects.equals(label, myClass.label) && Objects.equals(value, myClass.value);
//        return value.equalsIgnoreCase(myClass.value);
        return label.equalsIgnoreCase(myClass.label);
    }

    @Override
    public int compareTo(MyClass o) {
        return value.compareToIgnoreCase(o.value);
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
