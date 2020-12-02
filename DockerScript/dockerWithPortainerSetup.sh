#!/bin/bash
#判断命令是否执行成功

successOf(){
if [ $? -ne 0 ];
then
	echo "faild"
	return
else
	echo " "
	return 1
fi
}
echo "正在执行安装程序"
#创建或清空dockerWithPortainerSetup.log
echo > dockerWithPortainerSetup.log
#安装需要的软件包  yum-util 提供yum-config-manager功能
yum install -y yum-utils device-mapper-persistDepotent-data lvm2 >> dockerWithPortainerSetup.log
successOf
echo  "---------------->yum-config-manager依赖执行成功<------------------"
#设置docker的阿里仓库
yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo >> dockerWithPortainerSetup.log
successOf
echo  "---------------->设置Docker的阿里仓库成功<------------------"
#查看docker版本，选择特定版本安装
yum list docker-ce --showduplicates | sort -r  >> dockerWithPortainerSetup.log
successOf
echo  "---------------->选择特定版本安装,默认Docker-ce-18.03.1.ce<------------------"
#安装docker  默认的是docker-ce-18.03.1
yum install docker-ce-18.03.1.ce   -y  >> dockerWithPortainerSetup.log
successOf
echo  "---------------->Docker-ce-18.03.1安装成功<------------------"
#启动docker
systemctl start docker  >> dockerWithPortainerSetup.log
successOf
echo  "---------------->Docker安装成功<------------------"
#加入开机自启动
systemctl enable  docker >> dockerWithPortainerSetup.log
successOf

#查看docker版本
docker version
successOf

#安装成功
echo  "恭喜你，Docker安装成功！！！即将安装资源管理器portainer"
#下载指定portainer镜像
docker pull portainer/portainer  >>  dockerWithPortainerSetup.log
successOf
echo  "---------------->下载指定portainer镜像<------------------"
#下载汉化包
wget  https://dl.quchao.net/Soft/Portainer-CN.zip >>  dockerWithPortainerSetup.log
successOf
echo  "---------------->下载portainer汉化包成功<------------------"
#解压缩
unzip -o Portainer-CN.zip -d /public >>  dockerWithPortainerSetup.log
echo  "---------------->解压缩portainer汉化包到/public成功<------------------"
successOf
#启动命令
docker run -d -p 9000:9000 --restart=always  -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data -v /public:/public --name prtainer-test  portainer/portainer >>  dockerWithPortainerSetup.log
successOf
echo "恭喜你Docker资源管理器portainer安装成功！！！"
echo "请访问http://localhost:9000/"
