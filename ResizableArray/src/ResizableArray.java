import java.util.Arrays;

public class ResizableArray
{
    private int[] data;
    private int size;
    private final int DEFAULT_LENGTH = 50;

    public ResizableArray()
    {
        data = new int[DEFAULT_LENGTH];
        size = 0;
    }

    // FIRST WAVE METHODS

    public void add(int value)
    {
        if (data.length == size)
            resize();

        data[size] = value;
        size++;
    }

    private void resize()
    {
        int[] resizedData = Arrays.copyOf(data, size + 50);
        data = resizedData;
    }

    public int remove(int index)
    {
        if (index >= size || index < 0)
            throw new IllegalArgumentException("Index out of range of the data");

        int result = data[index];

        for (int j = index; j < size - 1; j++)
            data[j] = data[j + 1];

        size--;

        return result;
    }

    public int size()
    {
        return size;
    }

    public String toString()
    {
        String output = "[";

        for (int i = 0; i < size; i++)
        {
            int num = data[i];

            if (i != size - 1)
                output += (num + ", ");
            else output += (num + "]");
        }

        return output;
    }

    // SECOND WAVE METHODS

    public void insert(int index, int value)
    {
        if (index > size || index < 0)
            throw new IllegalArgumentException("Index out of range of the data");
        else if (size == data.length)
            resize();

        size++;

        for (int i = size - 1; i > index; i--)
            data[i] = data[i - 1];

        data[index] = value;

    }

    public int get(int index)
    {
        if (index >= size || index < 0)
            throw new IllegalArgumentException("Index out of range of the data");

        return data[index];
    }

    public void set(int index, int value)
    {
        if (index >= size || index < 0)
            throw new IllegalArgumentException("Index out of range of the data");

        data[index] = value;
    }

    public void sort()
    {
        for (int i = 0; i < size - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < size; j++)
                if (data[j] < data[index])
                    index = j;

            swap(index, i);

        }

    }

    private void swap(int indexA, int indexB)
    {
        int temp = data[indexA];
        this.set(indexA, data[indexB]);
        this.set(indexB, temp);
    }

    public int indexOf(int value)
    {
        int result = -1;

        for (int i = 0; i < size; i++)
        {
            if (data[i] == value)
            {
                result = i;
                break;
            }

        }

        return result;
    }

    public boolean equals(Object other)
    {
        if (other instanceof ResizableArray)
        {
            ResizableArray other2 = (ResizableArray) (other);

            if (size != other2.size())
                return false;

            for (int i = 0; i < size; i++)
            {
                if (data[i] != other2.data[i])
                {
                    return false;
                }
            }

            return true;
        }

        return false;

    }

    public int[] toArray()
    {
        int[] result = new int[size];

        for (int i = 0; i < size; i++)
        {
            result[i] = data[i];
        }

        return result;
    }

    // THIRD WAVE METHODS

    public void removeAll(int value)
    {
        for (int i = 0; i < size; i++)
        {
            if (data[i] == value)
            {
                for (int j = i; j < size - 1; j++)
                    data[j] = data[j + 1];

                size--;
                i--;
            }
        }
    }

}