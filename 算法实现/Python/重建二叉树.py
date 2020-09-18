class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def buildTree(preorder, midorder):
    if not preorder or not midorder:
        return None
    root = TreeNode(preorder[0])
    root.left = buildTree(preorder[1:midorder.index(preorder[0])+1], midorder[:midorder.index(preorder[0])])
    root.right = buildTree(preorder[midorder.index(preorder[0])+1:], midorder[midorder.index(preorder[0])+1:])
    return root

def visit_child_node(node,res):
    if not ( node.left or node.right):
        res[0] += 1
    if node.left:
        visit_child_node(node.left, res)
    if node.right:
        visit_child_node(node.right, res)


n = int(input().strip())
preorder = list(map(int,input().strip().split()))
midorder = list(map(int,input().strip().split()))

root = buildTree(preorder,midorder)


res = [0]
visit_child_node(root,res)
print(res[0])









x = []
x.insert()
