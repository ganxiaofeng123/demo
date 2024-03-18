package com.example.mysplash.Fragment.shanghai.Module;

import com.example.http.IRequest;
import com.example.http.annotion.RequestMethod;
import com.example.mysplash.Fragment.shanghai.dto.ShangHaiHttpBean;
import com.example.mysplash.base.JHResquest;

public interface ShangHaiDetailRequest {
    IRequest xiaohuarequest = JHResquest.sentHttp("/joke/content/list.php",RequestMethod.Get, ShangHaiHttpBean.class);
}
