package top.api;

import java.util.Map;

/**
 *  通用分页请求封装实体
 * @author 95271
 */
public class CommonPageParams {

    /**
     * 请求的页数
     */
    private Integer pageNum;
    /**
     *  分页条数
     */
    private Integer pageSize;
    /**
     * 分页条件
     */
    private Map<String, Object> pageParams;

    public Integer getPageNum() {
        return pageNum == null ? 1 : pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10: pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> getPageParams() {
        return pageParams;
    }

    public void setPageParams(Map<String, Object> pageParams) {
        this.pageParams = pageParams;
    }
}
