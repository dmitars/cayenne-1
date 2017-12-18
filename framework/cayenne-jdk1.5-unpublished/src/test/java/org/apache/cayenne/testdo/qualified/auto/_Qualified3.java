package org.apache.cayenne.testdo.qualified.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.testdo.qualified.Qualified4;

/**
 * Class _Qualified1 was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Qualified3 extends CayenneDataObject {

    public static final String NAME_PROPERTY = "name";
    public static final String QUALIFIED4S_PROPERTY = "qualified4s";

    public static final String ID_PK_COLUMN = "ID";

    public void setName(String name) {
        writeProperty(NAME_PROPERTY, name);
    }
    public String getName() {
        return (String)readProperty(NAME_PROPERTY);
    }

    public void addToQualified4s(Qualified4 obj) {
        addToManyTarget(QUALIFIED4S_PROPERTY, obj, true);
    }
    public void removeFromQualified4s(Qualified4 obj) {
        removeToManyTarget(QUALIFIED4S_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<Qualified4> getQualified2s() {
        return (List<Qualified4>)readProperty(QUALIFIED4S_PROPERTY);
    }


}
