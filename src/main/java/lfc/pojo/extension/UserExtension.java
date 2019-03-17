package lfc.pojo.extension;

import lfc.annotation.ORMAnnotation.Enumerated;
import lfc.pojo.base.BasePOJO;

public class UserExtension extends BasePOJO {
    @Enumerated(var = "group_")
    private Group group;

    public Group getGroup(){
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public enum Group{
        unLogin,user,admin,superAdmin;
    }
}
