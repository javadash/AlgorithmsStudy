

class Solution:
    def tilingRectangle(self, n: int, m: int) -> int:
        self.ret = n * m

        # using heights array and looking for minimum height,
        # we are putting squares from the bottom left
        def dfs(heights, moves):
            # all heights == n means that the rectangle is tiled
            if all(h == n for h in heights):
                self.ret = min(self.ret, moves)
                return
            # no need to search further
            if moves >= self.ret:
                return
            # looking for minimum height
            min_height, min_idx = min(heights), heights.index(min(heights))
            # calculate maximum allowed width
            rect_idx = min_idx + 1
            while rect_idx < m and heights[rect_idx] == min_height:
                rect_idx += 1
            # calculate maximum allowed length for a square
            maxLength = min(rect_idx - min_idx, n - min_height)

            # consider all cases
            for length in range(maxLength, 0, -1):
                # putting a square
                for k in range(min_idx, min_idx + length):
                    heights[k] += length
                # go further
                dfs(heights, moves + 1)
                # cancel the square
                for k in range(min_idx, min_idx + length):
                    heights[k] -= length

        dfs([0] * m, 0)
        return self.ret