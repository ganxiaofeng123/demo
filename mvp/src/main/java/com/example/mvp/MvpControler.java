package com.example.mvp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MvpControler implements ILifeCircle{
    //存放p层实例
    private Set<ILifeCircle> ILifeCircle =new HashSet<>();

    public void savePresenter(ILifeCircle iLifeCircle) {
        this.ILifeCircle.add(iLifeCircle);
    }
    public static MvpControler newInstance(){
        return new MvpControler();
    }
    @Override
    public void onCreate(Bundle saveInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> iterator = this.ILifeCircle.iterator();
        while (iterator.hasNext()){
           ILifeCircle next = iterator.next();
            if (intent == null){
                intent = new Intent();
            }
            if (getArguments == null){
                getArguments = new Bundle();
            }
            next.onCreate(saveInstanceState,intent,getArguments);
        }
    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> iterator1 = this.ILifeCircle.iterator();
        while (iterator1.hasNext()){
            ILifeCircle next1 = iterator1.next();
            if (intent == null){
                intent = new Intent();
            }
            if (getArguments == null){
                getArguments = new Bundle();
            }
            next1.onActivityCreated(saveInstanceState,intent,getArguments);
        }
    }

    @Override
    public void onStart() {
        Iterator<ILifeCircle> iterator2 = this.ILifeCircle.iterator();
        while (iterator2.hasNext()){
            ILifeCircle next2 = iterator2.next();
            next2.onStart();
        }
    }

    @Override
    public void onResume() {
        Iterator<ILifeCircle> iterator3 = this.ILifeCircle.iterator();
        while (iterator3.hasNext()){
            ILifeCircle next3 = iterator3.next();
            next3.onResume();
        }

    }

    @Override
    public void onPause() {
        Iterator<ILifeCircle> iterator4 = this.ILifeCircle.iterator();
        while (iterator4.hasNext()){
            ILifeCircle next4 = iterator4.next();
            next4.onPause();
        }
    }

    @Override
    public void onStop() {
        Iterator<ILifeCircle> iterator5 = this.ILifeCircle.iterator();
        while (iterator5.hasNext()){
            ILifeCircle next5 = iterator5.next();
            next5.onStop();
        }

    }

    @Override
    public void destoryView() {
        Iterator<ILifeCircle> iterator6 = this.ILifeCircle.iterator();
        while (iterator6.hasNext()){
            ILifeCircle next6 = iterator6.next();
            next6.destoryView();
        }

    }

    @Override
    public void onViewDestory() {
        Iterator<ILifeCircle> iterator7 = this.ILifeCircle.iterator();
        while (iterator7.hasNext()){
            ILifeCircle next7 = iterator7.next();
            next7.onViewDestory();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        Iterator<ILifeCircle> iterator8 = this.ILifeCircle.iterator();
        while (iterator8.hasNext()){
            ILifeCircle next8 = iterator8.next();
            if (intent == null)
                intent = new Intent();
            next8.onNewIntent(intent);
        }
    }

    @Override
    public void onDestory() {
        Iterator<ILifeCircle> iterator9 = this.ILifeCircle.iterator();
        while (iterator9.hasNext()){
            ILifeCircle next9 = iterator9.next();
            next9.onDestory();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Iterator<ILifeCircle> iterator10 = this.ILifeCircle.iterator();
        while (iterator10.hasNext()){
            ILifeCircle next10 = iterator10.next();
            next10.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        Iterator<ILifeCircle> iterator11 = this.ILifeCircle.iterator();
        while (iterator11.hasNext()){
            ILifeCircle next11 = iterator11.next();
            next11.onSaveInstanceState(bundle);
        }
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        Iterator<ILifeCircle> iterator12 = this.ILifeCircle.iterator();
        while (iterator12.hasNext()){
            ILifeCircle next12 = iterator12.next();
            next12.attachView(iMvpView);
        }
    }


}
