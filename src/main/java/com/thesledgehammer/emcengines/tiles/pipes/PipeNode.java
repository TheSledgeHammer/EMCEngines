package com.thesledgehammer.emcengines.tiles.pipes;

public class PipeNode<P> implements IPipeNode<P> {

    private P pipe;
    private PipeNode<P> next;
    private PipeNode<P> prev;

    PipeNode(P pipe) {
        setPipe(pipe);
        setNext(null);
        setPrev(null);
    }

    @Override
    public P getPipe() {
        return pipe;
    }

    public PipeNode<P> Next() {
        return next;
    }

    public PipeNode<P> Prev() {
        return prev;
    }

    @Override
    public void setPipe(P pipe) {
        this.pipe = pipe;
    }

    public void setNext(PipeNode<P> next) {
        this.next = next;
    }

    public void setPrev(PipeNode<P> prev) {
        this.prev = prev;
    }
}
