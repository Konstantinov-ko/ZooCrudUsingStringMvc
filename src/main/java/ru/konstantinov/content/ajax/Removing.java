package ru.konstantinov.content.ajax;

import ru.konstantinov.base.BaseAction;

/**
 * Created by Asus on 21.03.2017.
 */
class Removing implements AjaxAction {
    private int id;
    private boolean resultStatus;

    Removing(int id) {
        this.id = id;
    }

    public boolean makeAction() {
        resultStatus = new BaseAction().remove(this.id);
        return resultStatus;
    }

    public String getResult() {
        return (resultStatus) ? "{'zoo_id':'"+this.id+"'}" : "{'error':'true', 'zoo_id':'"+this.id+"'}";
    }
}
