package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.action.Action;
import ar.fiuba.tdd.tp.action.AddEdgeAction;
import ar.fiuba.tdd.tp.action.AffectAttributeAction;
import ar.fiuba.tdd.tp.action.RemoveEdgeAction;

import org.json.simple.JSONObject;

import java.util.Objects;

public class ActionParser {
    Action action = null;

    public ActionParser(JSONObject actionJson) {
        String type = (String) actionJson.get("type");
        if (Objects.equals(type, "add_edge")) {
            String src = (String) actionJson.get("src");
            String dst = (String) actionJson.get("dst");
            action = new AddEdgeAction(src, dst);
        } else if (Objects.equals(type, "remove_edge")) {
            String src = (String) actionJson.get("src");
            String dst = (String) actionJson.get("dst");
            action = new RemoveEdgeAction(src, dst);
        } else if (Objects.equals(type, "affect")) {
            String dst = (String) actionJson.get("dst");
            String attribute = (String) actionJson.get("attribute");
            Object value = actionJson.get("value");
            action = new AffectAttributeAction(dst, attribute, value.toString());
        }
    }

    public Action getAction() {
        return action;
    }
}
