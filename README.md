## 交流群 540686217

## 说明

> * 基于腾讯浏览服务，支持多种文件格式，例如doc、excel、ppt、excel、pdf等格式；
> * 支持展示网络文件
> * 支持测试本demo之前先把test文件夹里的文件复制到手机存储，方便测试，路径如下：
![这里写图片描述](https://github.com/ZhongXiaoHong/superFileView/blob/master/path.png?raw=true)

## TBS服务接入

参考腾讯TBS官网，地址：https://x5.tencent.com/tbs/guide/sdkInit.html

## 效果图
![这里写图片描述](https://github.com/ZhongXiaoHong/superFileView/blob/master/record.gif?raw=true)

## 常见问题
- no suport by

出现这个错误提示的原因，首先可能是手机上没有Tbs内核，如果有tbs内核，则可能是内核正在初始化安装，还处于冷启动阶段，这个时候内核还不能使用，打开文件会出现这个错误，可以使用可以按如下方式确定内核是否成功加载并且可用：
方法1：
```
  QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {

            }

            @Override
            public void onViewInitFinished(boolean b) {
              //这里被回调，并且b=true说明内核初始化并可以使用
              //如果b=false,内核会尝试安装，你可以通过下面监听接口获知
            }
        });

       QbSdk.setTbsListener(new TbsListener() {
           @Override
           public void onDownloadFinish(int i) {
              //tbs内核下载完成回调
          }

           @Override
           public void onInstallFinish(int i) {
              //内核安装完成回调，
          }

           @Override
           public void onDownloadProgress(int i) {
                //下载进度监听
           }
       });
```
方法2：
```
QbSdk.preInit(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
             
            }

            @Override
            public void onViewInitFinished(boolean b) {
              
            }
        });
        //tbs内核下载跟踪
        QbSdk.setTbsListener(this.tbsListener);
        //判断是否要自行下载内核
        boolean needDownload = TbsDownloader.needDownload(this, TbsDownloader.DOWNLOAD_OVERSEA_TBS);
        if (needDownload && isNetworkWifi(this)) {
        //isNetworkWifi(this)是我
        //自己写的一个方法，这里我也希望wifi下再下载
            TbsDownloader.startDownload(this);
        }
```
方法1、方法2 主要的区别在于方法1更加“自动”，内部会自动判断需不需要下载内核，因此在使用方法1来初始化的话，需要注意一下,此时tbs内核在非Wifi状态下是默认不会下载的，你可以通过以下方法来改变这个设置：
  QbSdk.setDownloadWithoutWifi(true);
  


- 插件加载失败

首次打开相关文件的时候需要下载相关文件的插件，因此需要保持网络可用状态，否则下载插件失败会出现这个错误。

- NoSuchMethodException: onCallBackAction 

这个错误我也是懵逼，不管成功打开与否，都会有这玩意，所以暂时先忽略。



## 博客
http://www.jianshu.com/p/3f57d640b24d
