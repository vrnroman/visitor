package sg.roman.model;

import sg.roman.action.Visitor;

public interface Visitorable {

    Object accept(Visitor visitor);
}
