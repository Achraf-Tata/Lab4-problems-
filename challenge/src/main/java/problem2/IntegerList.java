package problem2;

public class IntegerList
{
    int[] list;
    int numberOfElements;
    int size;

    public IntegerList(int size)
    {
        list = new int[size];
        this.size = size;
        this.numberOfElements = 0;
    }

    public void randomize()
    {
        for (int i = 0; i < list.length; i++) list[i] = (int)(Math.random() * 100) + 1;
        numberOfElements = list.length;
    }

    public void print()
    {
        for (int i = 0; i < numberOfElements; i++) System.out.println(i + " : " + list[i]);
    }

    public void increaseSize()
    {
        int[] newList = new int[list.length * 2];
        for (int i = 0; i < list.length; i++) newList[i] = list[i];
        list = newList;
        size = list.length;
    }

    public void addElement(int newVal)
    {
        if (numberOfElements == list.length) increaseSize();
        list[numberOfElements] = newVal;
        numberOfElements++;
    }

    public void removeFirst(int newVal)
    {
        for (int i = 0; i < numberOfElements; i++)
        {
            if (list[i] == newVal)
            {
                for (int j = i; j < numberOfElements - 1; j++)
                    list[j] = list[j + 1];
                numberOfElements--;
                return;
            }
        }
    }

    public void removeAll(int newVal)
    {
        for (int i = 0; i < numberOfElements; i++)
        {
            if (list[i] == newVal)
            {
                for (int j = i; j < numberOfElements - 1; j++) list[j] = list[j + 1];
                numberOfElements--;
                i--;
            }
        }
    }
}