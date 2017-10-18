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

## 后续：Bug 修复
网友反映有些手机加载不了文件，会出现以下画面：

![文件预览失败.png](http://upload-images.jianshu.io/upload_images/4447058-2268af81ee6d4dee.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

经过排查发现原因如下：

![错误原因.png](http://upload-images.jianshu.io/upload_images/4447058-75bc9558f63f5a5d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

解决办法：

![2解决错误.png](http://upload-images.jianshu.io/upload_images/4447058-de46de169150eaab.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

另外一种方式确定是不是这个原因导致的文件加载失败，你可以文件管理器那里看看有没有这个文件夹存在，如下：

![没有Temp文件夹.png](http://upload-images.jianshu.io/upload_images/4447058-49a21aa175bdc927.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 声明
之前有很多小伙伴遇到这个问题，刚好遇到国庆所以没有及时跟进，国庆后积压的工作有点多，都在还债，拖得有点久，很抱歉！现在终于搞定这个bug了，代码也已经同步github，各位可以检验一下。

## 博客
http://www.jianshu.com/p/3f57d640b24d
