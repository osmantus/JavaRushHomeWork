package com.javarush.test.level20.lesson10.home09;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Serializable
{
    int node;
    List<Solution> edges = new LinkedList<>();

    Solution(int node)
    {
        this.node = node;
    }

    Solution()
    {}

    public static void main(String[] args) throws Exception
    {
        Solution sol = new Solution();

        sol.createList();

        ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("D:\\Work\\Java\\L20Les10T9\\test.txt"));
        outStream.writeObject(sol);
        outStream.close();

        ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("D:\\Work\\Java\\L20Les10T9\\test.txt"));
        sol = (Solution) inStream.readObject();
        inStream.close();
    }

    private void writeObject(ObjectOutputStream out) throws IOException
    {
        if (edges != null)
        {
            out.writeObject(node);
            /*for (Solution eachSol : edges)
            {*/
                //out.writeObject(eachSol);
            //}
            out.writeObject(edges);
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        //in.defaultReadObject();

        Solution sol = null;

        try
        {
            node = (int) in.readObject();
            //sol = new Solution(node);
            edges = (List<Solution>) in.readObject();
            this.setEdges(edges);
        }
        catch (Exception e)
        {

        }
    }

    public List<Solution> getEdges()
    {
        return edges;
    }

    public void setEdges(List<Solution> sol)
    {
        edges = sol;
    }

    public void createList()
    {
        Solution sol1 = new Solution(1);
        Solution sol2 = new Solution(2);
        Solution sol3 = new Solution(3);
        Solution sol4 = new Solution(4);
        Solution sol5 = new Solution(5);
        Solution sol6 = new Solution(6);

        List<Solution> list = null;

        list = sol1.getEdges();
        list.add(sol2);
        list.add(sol4);
        sol1.setEdges(list);

        list = sol2.getEdges();
        list.add(sol5);
        sol2.setEdges(list);

        list = sol3.getEdges();
        list.add(sol6);
        list.add(sol5);
        sol3.setEdges(list);

        list = sol4.getEdges();
        list.add(sol2);
        sol4.setEdges(list);

        list = sol5.getEdges();
        list.add(sol4);
        sol5.setEdges(list);

        // 6-ой элемент ссылается на себя самого
        list = sol6.getEdges();
        list.add(sol6);
        sol6.setEdges(list);

        // устанавливаем все объекты по очереди в списочный объект внутри текущего объекта
        edges.add(0, sol1);
        edges.add(1, sol2);
        edges.add(2, sol3);
        edges.add(3, sol4);
        edges.add(4, sol5);
        edges.add(5, sol6);
    }
}
