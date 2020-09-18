edges = []

bcj = [i for i in range(len(edges) +1)]


def find(bcj,index):
    while bcj[index] != index:
        # 压缩路径
        bcj[index] = bcj[bcj[index]]
        index = bcj[index]
    return index


def union_bcj(bcj, pre_node, next_node):
     bcj[find(bcj,next_node)] = bcj[find(bcj,pre_node)]