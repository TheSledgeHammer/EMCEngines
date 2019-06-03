package com.thesledgehammer.emcengines.tiles.pipes;

import groovydatastructuresalgorithms.CircularDoublyLinkedList;

public class PipeManager<P> {

    private PipeNode<P> head;
    private CircularDoublyLinkedList<PipeNode<P>> root;
    private int size = 0;

    public PipeManager(P pipe) {
        head = new PipeNode<P>(pipe);
        root = new CircularDoublyLinkedList<PipeNode<P>>(new PipeNode<>(pipe));
    }

    public PipeManager() {
        head = null;
        root = new CircularDoublyLinkedList<PipeNode<P>>();
    }

    public boolean isEmpty() {
        if(root == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void add(P pipe) {
        PipeNode<P> node = new PipeNode<P>(pipe);
        if(size == 0 || root == null) {
            node.setNext(node);
            node.setPrev(node);
        } else {
            node.setNext(node);
            node.setPrev(node);
        }
        root.add(node);
        size++;
    }

    public P get(P pipe) {
        PipeNode<P> node = new PipeNode<P>(pipe);
        if(root.contains(node) && node.getPipe().equals(pipe)) {
            return pipe;
        }
        return null;
    }
}
