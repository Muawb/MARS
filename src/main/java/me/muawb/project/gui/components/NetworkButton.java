package me.muawb.project.gui.components;

import java.util.List;

public interface NetworkButton {

    void addButtonOfNames(List<String> names);

    CustomJButton createButtonOfNames(String name);
}
