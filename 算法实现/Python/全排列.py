"""
version 1,不剔除重复元素，不对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这
个数所在重复数集合中「从左往右第一个未被填过的数字」
https://leetcode-cn.com/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/
"""

def permuteUnique_1(nums):
    res = []
    def find_per(nums, index):
        if index == len(nums):
            res.append(nums.copy())
        for i in range(index, len(nums)):
            nums[index], nums[i] = nums[i], nums[index]
            find_per(nums, index + 1)
            nums[index], nums[i] = nums[i], nums[index]
    find_per(nums, 0)
    return res



"""
version 2,剔除重复元素，对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这
个数所在重复数集合中「从左往右第一个未被填过的数字」
https://leetcode-cn.com/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/
"""

def permuteUnique_2(nums):
    visited = [0] * len(nums)
    res = []
    perm = []
    nums = sorted(nums)

    def backtrack(nums, index, perm,visited):
        if index == len(nums):
            res.append(perm)
            return None
        for i in range(0, len(nums)):
            if visited[i] or (i > 0 and nums[i] == nums[i-1] and not visited[i-1]):
                continue
            perm.append(nums[i])
            visited[i] = 1
            backtrack(nums, index+1, perm.copy(), visited)
            visited[i] = 0
            perm.pop()
    backtrack(nums, 0, perm,visited)
    return res

"""
version 3,调用api
"""

def permuteUnique_3(nums):
    import itertools
    return list(itertools.permutations(nums))


if __name__ == '__main__':
    nums = [1, 2, 3,4]
    #print(len(permuteUnique_1(nums)))
    #print(permuteUnique_2(nums))
    #print(len(permuteUnique_3(nums)))

