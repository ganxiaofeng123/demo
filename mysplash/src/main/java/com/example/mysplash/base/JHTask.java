package com.example.mysplash.base;

import com.example.http.IResultCallBack;
import com.example.http.result.IResult;
import com.example.http.result.Result;
import com.example.task.LfTask;
    //利用泛型结合task和http
    public abstract class JHTask<T> extends LfTask<IResult<T>> implements IResultCallBack<T> {

        public void onFailure(IResult t) {
            switch (t.getCode()){
                //统一错误码的处理
                case Result.CODE_404:
                    break;
                    case Result.CODE_504:
                        break;
                        case Result.CODE_505:
                            break;
            }
        }

        @Override
        public void onComplete(IResult<T> iResult) {
            if (iResult!=null){
                if (iResult.isSuccess()){
                    onSuccess(iResult);
                }else{
                    onFailure( Result.failed(Result.CODE_505));//一次失败
                }
            }else{
                onFailure( Result.failed(Result.CODE_504));//二次失败
            }
        }

        @Override
        public void onExeception(Throwable throwable) {
            onFailure(Result.failed(Result.CODE_404));//三次失败
        }
    }

