package lfc.mapper.ORM;

import lfc.pojo.Product;

import java.util.List;

/**
 *  通用 Mapper | 对 mapper 的 所有函数进行静态代理，供调用使用
 */

@SuppressWarnings("unchecked")
public class Mapper extends Mapper4ORM {

    private int defaultTraversalDepth = 1;

    public Object selectByPrimaryKey(Integer id) throws Exception {
        return selectByPrimaryKey(id, defaultTraversalDepth);
    }

    public Object selectByPrimaryKey(Integer id, Integer depth) throws Exception {
        Object object = mapper.getClass().getMethod("selectByPrimaryKey", Integer.class).invoke(mapper, id);
//        fillOnReading(object, depth);
        return object;
    }

    public int insert(Object object) throws Exception {
        fillOnWriting(object);
        return (int) mapper.getClass().getMethod("insert", object.getClass()).invoke(mapper, object);
    }

    public int insertSelective(Object object) throws Exception {
        fillOnWriting(object);
        return (int) mapper.getClass().getMethod("insertSelective", Object.class).invoke(mapper, object);
    }

    public int updateByPrimaryKeySelective(Object object) throws Exception {
        fillOnWriting(object);
        return (int) mapper.getClass().
                getMethod("updateByPrimaryKeySelective", object.getClass()).invoke(mapper, object);
    }

    public int updateByPrimaryKey(Object object) throws Exception {
//        fillOnWriting(object);
        return (int) mapper.getClass().getMethod("updateByPrimaryKey", object.getClass()).invoke(mapper, object);
    }

    public List selectByExample(Object example) throws Exception {
        return selectByExample(example, defaultTraversalDepth);
    }

    public List selectByExample(Object example, int depth) throws Exception {
        List result = (List) mapper.getClass().getMethod("selectByExample", example.getClass()).invoke(mapper, example);
        for (int i = 0; i < result.size(); i++) {
            Object item = result.get(i);
            fillOnReading(item, depth);
            result.set(i, item);
        }
        return result;
    }
    public List selectByExampleALL(Object example) throws Exception {
        List result = (List) mapper.getClass().getMethod("selectByExample", example.getClass()).invoke(mapper, example);
        return result;
    }
    public Integer selectByExampleSingle(Object example) throws Exception {
        Integer result = (Integer) mapper.getClass().getMethod("selectByExampleSingle", example.getClass()).invoke(mapper, example);
        return result;
    }
    public Object selectByPrimaryKeySingle(Integer id) throws Exception {
        Object object = mapper.getClass().getMethod("selectByPrimaryKey", Integer.class).invoke(mapper, id);
        return object;
    }
    public int insertSingle (Object object) throws Exception{
        return (int) mapper.getClass().getMethod("insert", object.getClass()).invoke(mapper, object);
    }
    public List selectAllByUID (Integer uid)throws Exception{
        List result = (List) mapper.getClass().getMethod("selectAllByUID",Integer.class).invoke(mapper, uid);
        return result;
    }
    public Object selectByPid(Integer pid)throws Exception{
        Object object = mapper.getClass().getMethod("selectByPid", Integer.class).invoke(mapper, pid);
        return object;
    }

    public Object selectByExampleWtih2Id(Object example) throws Exception{
        Object object = mapper.getClass().getMethod("selectByExampleWtih2Id", example.getClass()).invoke(mapper, example);
        return object;
    }


}
