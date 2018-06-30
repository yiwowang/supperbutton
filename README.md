<br>SupperButton一个多功能自定义shape按钮
<br>SupperLayout一个多功能shape布局
<br>ClipLayout一个裁剪内容的布局，例如裁剪fresco gif为圆角。（当时PM要求Gif必须要圆角时我曾哭晕在厕所）
<br>为了减少大家工作量，所以写了此控件，接下来一个一个的介绍吧
<br># SupperButton
<br>在Android开发中，例如，定义一个圆角按钮，需要定义shape,以及按下态selector，这需要新建好多xml文件，本源码一个按钮控件全部搞定所有情况，同时支持按下态改变透明度效果，只需要在布局里修改几个属性值，无需自己写java代码，使用非常简单。
<br>#使用方法：
<br>详见demo布局文件。

<br>按钮一共四种状态，分别是
<br>1、normal 正常状态，也就是默认状态
<br>2、pressed 按下状态，当按钮被按下后的状态，当松开按钮会恢复到normal状态
<br>3、disable 无效状态，当控件设定为setEnable(false)时会切换为该状态，当设定setEnable(true)时恢复normal状态
<br>4、selected 选中状态，当控件设定为setSelected(true)会切换为该状态，当setSelected(true)时恢复normal状态
<br>属性均以这四个状态开头，代表不同状态下的属性，例如下面写法：

<!--背景为自定义的形状，按下态为透明度50%-->
        <com.yiwowang.superbutton.SupperButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:clickable="true"
            android:gravity="center"
            android:padding="10dp"
            android:text="我是按钮"
            app:normalRadius="10dp"
            app:normalSolidColor="@android:color/holo_blue_dark"
            app:normalStrokeColor="@android:color/holo_red_dark"
            app:normalStrokeWidth="3dp"
            app:normalTextColor="@android:color/holo_green_light"
            app:pressedAlpha="0.5" />

<!--背景为自定义形状，按下态也为自定义形状-->
        <com.yiwowang.superbutton.SupperButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:clickable="true"
            android:gravity="center"
            android:padding="10dp"
            android:text="我是按钮"
            app:normalRadius="10dp"
            app:normalSolidColor="@android:color/holo_blue_dark"
            app:normalStrokeColor="@android:color/holo_red_dark"
            app:normalStrokeWidth="3dp"
            app:normalTextColor="@android:color/white"
            app:pressedRadius="10dp"
            app:pressedSolidColor="@android:color/holo_green_light"
            app:pressedStrokeColor="@android:color/holo_orange_dark"
            app:pressedStrokeWidth="3dp"
            app:pressedTextColor="@android:color/black" />
<br>
<br>
<br>#SupperLayout 如果需要使用shape作为背景，可以使用SupperLayout，基类为FrameLayout，同样支持按下态
<br>
<br>
<br>#ClipLayout 是一个裁剪任何view的布局，例如可以将fresco的gif动画裁剪为圆角矩形
![Image text](https://raw.githubusercontent.com/yiwowang/supperbutton/master/Screenshots/Screenshot_supper_button.png)
![Image text](https://raw.githubusercontent.com/yiwowang/supperbutton/master/Screenshots/Screenshot_clip_layout.png)
<br>有问题和建议可以联系我，QQ:958796636