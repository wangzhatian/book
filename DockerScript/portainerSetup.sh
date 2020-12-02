#!/bin/bash
#判断命令是否执行成功
successOf(){
if [ $? -ne 0 ];
then
	echo "faild"
	return
else
	echo "success"
	return 1
fi
}
echo "正在执行安装程序"
#创建或清空portainerSetup.log
echo > portainerSetup.log
#下载指定portainer镜像
docker pull portainer/portainer  >>  portainerSetup.log
successOf
echo  "---------------->下载指定portainer镜像<------------------"
#下载汉化包
wget  https://dl.quchao.net/Soft/Portainer-CN.zip >>  portainerSetup.log
successOf
echo  "---------------->下载portainer汉化包成功<------------------"
#解压缩
unzip -o Portainer-CN.zip -d /public >>  portainerSetup.log
echo  "---------------->解压缩portainer汉化包到/public成功<------------------"
successOf
#启动命令
docker run -d -p 9000:9000 --restart=always  -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data -v /public:/public --name prtainer-test  portainer/portainer >>  portainerSetup.log
successOf
echo "恭喜你Docker资源管理器portainer安装成功！！！"
echo "请访问http://localhost:9000/"
