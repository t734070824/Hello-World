#!/bin/sh
 # 在当前文件夹下创建3个文件夹
mkdir data conf logs
 # 分别在3个文件夹下创建6个以redis-开头的文件夹
for dir in data conf logs
do
  for i in {1..6}
  do
    mkdir $dir/redis-$i
  done
done