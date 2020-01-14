<template>
  	<div>
        <el-row>
        <head-top></head-top>
        </el-row>
        <el-row>
            <div class="minder">
                <el-menu mode="horizontal">
                    <el-menu-item index="1">主页</el-menu-item>
                    <el-menu-item index="2">推荐</el-menu-item>
                    <el-submenu index="3">
                        <template slot="title">作品展示</template>
                        <el-menu-item index="3-1">选项1</el-menu-item>
                        <el-menu-item index="3-2">选项2</el-menu-item>
                        <el-menu-item index="3-3">选项3</el-menu-item>
                        <el-submenu index="3-4">
                            <template slot="title">选项4</template>
                            <el-menu-item index="3-4-1">选项1</el-menu-item>
                            <el-menu-item index="3-4-2">选项2</el-menu-item>
                            <el-menu-item index="3-4-3">选项3</el-menu-item>
                        </el-submenu>
                    </el-submenu>
                    <el-menu-item index="4">资料</el-menu-item>
                    <el-menu-item index="5" disabled>电影</el-menu-item>
                    <el-menu-item index="6">壁纸</el-menu-item>
                </el-menu>
            </div>
        </el-row>
  	</div>
</template>

<script>
    import headTop from '../components/headTop'

	export default {
	    data(){
			return {
			}
		},
        components: {
            headTop,
        },
		mounted(){
		},
		computed: {
		},
		methods: {

		},
		watch: {

		}
	}
</script>

<style>
    .minder {
        width: 70%;
        margin: 0 auto; /*水平居中*/

    }
    .el-menu {
        background-color: white;
    }
</style>
