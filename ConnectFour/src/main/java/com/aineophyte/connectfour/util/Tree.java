package com.aineophyte.connectfour.util;

import java.util.ArrayList;
import java.util.List;

public class Tree<T>
{
	private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>(rootData);
    }
    
    public Node<T> getRoot()
    {
    	return root;
    }

    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private List<Node<T>> children;
        
        public Node(T data)
        {
        	this.data = data;
        	this.children = new ArrayList<Node<T>>();
        }
        
        public Node<T> addChild(T data)
        {
        	Node<T> node = new Node<T>(data);
        	node.parent = this;
        	children.add(node);
        	return node;
        }
        
        public T getData()
        {
        	return data;
        }
        
        public Node<T> getParent()
        {
        	return parent;
        }
        
        public List<Node<T>> getChildren()
        {
        	return children;
        }
    }
}
