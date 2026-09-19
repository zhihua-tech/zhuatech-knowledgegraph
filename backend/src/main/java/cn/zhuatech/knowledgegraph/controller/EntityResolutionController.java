/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.knowledgegraph.controller;import cn.zhuatech.knowledgegraph.service.EntityResolutionService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController@RequestMapping("/api/knowledgegraph")public class EntityResolutionController{private final EntityResolutionService service;/**
                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                            */
public EntityResolutionController(EntityResolutionService s){service=s;}/**
                                                                                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                    */
@PostMapping("/entity-resolution")public EntityResolutionService.Result resolve(@Valid@RequestBody EntityResolutionService.Request r){return service.resolve(r);}}
