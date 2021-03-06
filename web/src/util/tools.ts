export class Tool {

    /**
     * 空校验 null或""都返回true
     */
    private static v: Set<number>;


    public static isEmpty(obj: any) {
        if ((typeof obj === 'string')) {
            return !obj || obj.replace(/\s+/g, "") === ""
        } else {
            return (!obj || JSON.stringify(obj) === "{}" || obj.length === 0);
        }
    }

    /**
     * 非空校验
     */
    public static isNotEmpty(obj: any) {
        return !this.isEmpty(obj);
    }

    /**
     * 对象复制
     * @param obj
     */
    public static copy(obj: object) {
        if (Tool.isNotEmpty(obj)) {
            return JSON.parse(JSON.stringify(obj));
        }
    }

    /**
     * 使用递归将数组转为树形结构
     * 父ID属性为parent
     */
    public static array2Tree(array: any, parentId: number){
        if (Tool.isEmpty(array)) {
            return [];
        }

        const result = [];
        for (let i = 0; i < array.length; i++) {
            const c = array[i];

            // console.log(Number(c.parent), Number(parentId));
            if (Number(c.parent) === Number(parentId)) {
                result.push(c);
                // 递归查看当前节点对应的子节点
                const children = Tool.array2Tree(array, c.id);
                if (Tool.isNotEmpty(children)) {
                    c.children = children;
                }
            }
        }
        return result;
    }

    /**
     * Recursively set node and children node as disabled
     * cannot be chosen
     */
    public static setDisable (treeSelect: any, id: number) {
        for (let i = 0; i < treeSelect.length; i++) {
            const node = treeSelect[i];
            if (node.id == id) {
                console.log("-----Disable Node-----",node.id);
                node.disabled = true;
                const child = node.children;
                if(Tool.isEmpty(child)){
                    continue;
                }
                for (let j = 0; j < child.length; j++) {
                    const c = child[j];
                    Tool.setDisable(child, c.id);
                }
            } else {
                const child = node.children;
                if (!Tool.isEmpty(child)) {
                    Tool.setDisable(child, id);
                }
            }
        }
    }

    /**
     * Recursively search the tree and add IDs in one entire branch
     */

    public static deleteIDs (tree: any, id: bigint,IDlist:Array<bigint>){

        for (let i = 0; i < tree.length; i++) {
            const node = tree[i];
            if (node.id == id) {
                const child = node.children;
                IDlist.push(id);
                if (Tool.isEmpty(child)) {
                    continue;
                }
                for (let j = 0; j < child.length; j++) {
                    const c = child[j];
                    Tool.deleteIDs(child, c.id,IDlist);
                }
            } else {
                const child = node.children;
                if (!Tool.isEmpty(child)) {
                    Tool.deleteIDs(child, id,IDlist);
                }
            }
        }
    }
}