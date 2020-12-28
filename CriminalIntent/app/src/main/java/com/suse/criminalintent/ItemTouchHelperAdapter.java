package com.suse.criminalintent;

/**
 * @author liujing
 * @version 1.0
 * @date 2020/12/28 23:25
 */
public interface ItemTouchHelperAdapter {
    //数据交换
    void onItemMove(int fromPosition,int toPosition);
    //数据删除
    void onItemDismiss(int position);
}
