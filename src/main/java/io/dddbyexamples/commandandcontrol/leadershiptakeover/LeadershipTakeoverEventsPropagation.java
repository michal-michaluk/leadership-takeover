package io.dddbyexamples.commandandcontrol.leadershiptakeover;

class LeadershipTakeoverEventsPropagation implements Events {

    private SentCommandList list;
    // private POpup popup;
    // private Table table;
    // private Map map;

    @Override
    public void emit(NewCommand event) {
        list.apply(event);
        // map.apply(event);
        // popup.apply(event);
        // table.apply(event);
    }
}
