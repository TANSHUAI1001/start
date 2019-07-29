# Redis Publish 命令
Redis Publish 命令用于将信息发送到指定的频道。
```
PUBLISH channel message
```

# Redis Unsubscribe 命令
```
UNSUBSCRIBE channel [channel ...]
```

# Redis Subscribe 命令
```
SUBSCRIBE channel [channel ...]
```

# Redis Pubsub 命令
Redis Pubsub 命令用于查看订阅与发布系统状态，它由数个不同格式的子命令组成。
```
PUBSUB <subcommand> [argument [argument ...]]
```
## PUBSUB CHANNELS [pattern]
列出当前active channels.活跃是指信道含有一个或多个订阅者(不包括从模式接收订阅的客户端) 
如果pattern未提供，所有的信道都被列出，否则只列出匹配上指定全局-类型模式的信道被列出.

## PUBSUB NUMSUB [channel-1 ... channel-N]
列出指定信道的订阅者个数(不包括订阅模式的客户端订阅者)

## PUBSUB NUMPAT
返回订阅模式的数量(使用命令PSUBSCRIBE实现).
注意， 这个命令返回的不是订阅模式的客户端的数量， 而是客户端订阅的所有模式的数量总和。

# Redis Punsubscribe 命令
Redis Punsubscribe 命令用于退订所有给定模式的频道。
```
PUNSUBSCRIBE [pattern [pattern ...]]
```

# Redis Psubscribe 命令
Redis Psubscribe 命令订阅一个或多个符合给定模式的频道。
```
PSUBSCRIBE pattern [pattern ...]
```